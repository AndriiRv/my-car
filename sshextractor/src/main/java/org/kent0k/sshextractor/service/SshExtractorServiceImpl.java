package org.kent0k.sshextractor.service;

import org.kent0k.sshextractor.dto.MyCarSshExtractorConfigDto;
import org.kent0k.sshextractor.exception.SshExtractorException;
import org.kent0k.sshextractor.helper.ApplicationContextHelper;
import org.kent0k.sshextractor.helper.FileHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SshExtractorServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(SshExtractorServiceImpl.class);

    private static final String OS_USER_HOME = System.getProperty("user.home");

    private static final String CURRENT_PROJECT_DIR_NAME = System.getProperty("user.dir");

    private final MyCarSshExtractorConfigDto configDto;
    private final ApplicationContextHelper applicationContextHelper;
    private final FileHelper fileHelper;

    public SshExtractorServiceImpl(MyCarSshExtractorConfigDto configDto,
                                   ApplicationContextHelper applicationContextHelper,
                                   FileHelper fileHelper) {
        this.configDto = configDto;
        this.applicationContextHelper = applicationContextHelper;
        this.fileHelper = fileHelper;
    }

    /**
     * Batch method which intend to add ssh files from host OS to root of 'My-car' projects.
     *
     * @return boolean flag which explain whether ssh files added correctly.
     */
    public boolean addSshFilesToProjectDirectory() {
        Path projectSshDirectoryPath = Paths.get(
                Paths.get(CURRENT_PROJECT_DIR_NAME).getParent().toAbsolutePath().toString(),
                configDto.projectSshFolderName()
        ).toAbsolutePath();

        if (fileHelper.isDirectoryExistsAndFilled(projectSshDirectoryPath)) {
            LOG.info(String.format("Ssh folder files (%s) already exist and filled.", projectSshDirectoryPath));
            return true;
        }

        Path systemPathToSsh = Paths.get(OS_USER_HOME, configDto.osSshFolderName());
        final List<String> fileNames = fileHelper.fetchFileNamesBySpecificDirectory(systemPathToSsh);

        handleSshData(systemPathToSsh, fileNames, projectSshDirectoryPath);

        return true;
    }

    /**
     * Gather content of all files from ssh system folder.
     *
     * @return map where key is file name and value is a list with text contents row-by-row.
     */
    boolean handleSshData(Path systemPathToSsh, List<String> fileNames, Path projectSshDirectoryPath) {
        short ranThreads = 0;
        List<Thread> threads = new ArrayList<>();

        for (short currentFileNameIndex = 0; currentFileNameIndex < fileNames.size(); currentFileNameIndex++) {
            if (ranThreads <= Runtime.getRuntime().availableProcessors()) {
                SshExtractorMultithreadServiceImpl service = applicationContextHelper.getBean(SshExtractorMultithreadServiceImpl.class);
                service.setFileName(fileNames.get(currentFileNameIndex));
                service.setPathToSshFile(systemPathToSsh.toAbsolutePath().toString());
                service.setProjectSshDirectoryPath(projectSshDirectoryPath.toAbsolutePath().toString());

                Thread thread = new Thread(service);
                threads.add(thread);
                thread.start();

                ranThreads++;
            } else {
                if (isAnyDeadThreadExists(threads, configDto.threadTimeout())) {
                    ranThreads = (short) threads.stream().filter(Thread::isAlive).count();
                }
                currentFileNameIndex--; // make sure that we come back to the file which should be handled by thread on iteration where all threads were busy.
            }
        }
        return true;
    }

    /**
     * This method is need to wait until threads which is currently running died then we can create another threads.
     * Plan is about contains active threads which equals to OS core count.
     * <p>
     * So wait until any of ran threads will die and return true after that.
     * <p>
     * If after specific seconds none of threads are dead then throw exception and therefore will exit from the infinite loop.
     *
     * @param threads list of active threads.
     * @param deadlineSeconds time after that we need to break the loop.
     * @return boolean flag is any of threads are dead.
     */
    boolean isAnyDeadThreadExists(List<Thread> threads, short deadlineSeconds) {
        LocalDateTime localDateTimePlusSeconds = LocalDateTime.now().plusSeconds(deadlineSeconds);

        while (true) {
            if (localDateTimePlusSeconds.isBefore(LocalDateTime.now())) {
                throw new SshExtractorException(String.format("None of ran threads was died after %s seconds", deadlineSeconds));
            }
            return threads.stream().anyMatch(e -> !e.isAlive());
        }
    }

    boolean readAndWriteSshData(String pathToSshFile, String fileName, String projectSshDirectoryPath) {
        List<String> readLines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathToSshFile, fileName))) {
            String currentTextRow;
            while ((currentTextRow = reader.readLine()) != null) {
                readLines.add(currentTextRow);
            }

            writeSshData(projectSshDirectoryPath, fileName, readLines);
        } catch (IOException e) {
            throw new SshExtractorException(String.format("Exception during read content from %s", fileName), e.getCause());
        }

        return true;
    }

    boolean writeSshData(String destination, String fileName, List<String> fileContent) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(destination, fileName))) {
            for (String currentTextRow : fileContent) {
                writer.write(currentTextRow);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new SshExtractorException(String.format("Exception during write contents to '%s' file by '%s' path", fileName, destination),
                    e.getCause());
        }
        return true;
    }
}
