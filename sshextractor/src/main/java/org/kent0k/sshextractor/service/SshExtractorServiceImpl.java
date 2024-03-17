package org.kent0k.sshextractor.service;

import org.kent0k.sshextractor.dto.MyCarSshExtractorConfigDto;
import org.kent0k.sshextractor.exception.SshExtractorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SshExtractorServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(SshExtractorServiceImpl.class);

    private static final String OS_USER_HOME = System.getProperty("user.home");

    private static final String CURRENT_PROJECT_DIR_NAME = System.getProperty("user.dir");

    private final MyCarSshExtractorConfigDto configDto;

    public SshExtractorServiceImpl(MyCarSshExtractorConfigDto configDto) {
        this.configDto = configDto;
    }

    /**
     * Batch method which intend to add ssh files from host OS to root of 'My-car' projects.
     *
     * @return boolean flag which explain whether ssh files added correctly.
     */
    public boolean addSshFilesToProjectDirectory() {
        Path projectSshDirectoryPath = Paths.get(
                Paths.get(CURRENT_PROJECT_DIR_NAME).getParent().toAbsolutePath().toString(),
                configDto.getProjectSshFolderName()
        ).toAbsolutePath();

        if (isDirectoryExistsAndFilled(projectSshDirectoryPath)) {
            LOG.info(String.format("Ssh folder files (%s) already exist and filled.", projectSshDirectoryPath));
            return true;
        }

        Map<String, List<String>> readSshDataMap = readSshData();
        writeSshData(projectSshDirectoryPath.toString(), readSshDataMap);

        String sshFileNames = String.join(",", readSshDataMap.keySet());
        LOG.info(String.format("Ssh files (%s) was added to '%s' successfully.", sshFileNames, projectSshDirectoryPath));

        return true;
    }

    /**
     * Check whether directory and at least one file in there also exists.
     *
     * @param path path where need to create directory.
     * @return boolean flag return true where directory already exists and filled with at least one file.
     */
    boolean isDirectoryExistsAndFilled(Path path) {
        if (Files.exists(path) && !fetchFileNamesBySpecificDirectory(path).isEmpty()) {
            return true;
        }

        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                return false;
            } catch (IOException e) {
                throw new SshExtractorException(String.format("Exception during create new directory by %s", path), e.getCause());
            }
        }
        return false;
    }

    /**
     * Gather content of all files from ssh system folder.
     *
     * @return map where key is file name and value is a list with text contents row-by-row.
     */
    Map<String, List<String>> readSshData() {
        Path pathToSshFile = Paths.get(OS_USER_HOME, configDto.getOsSshFolderName());
        final List<String> fileNames = fetchFileNamesBySpecificDirectory(pathToSshFile);

        Map<String, List<String>> map = new HashMap<>();
        for (String fileName : fileNames) {
            List<String> readLines = new ArrayList<>();

            try (BufferedReader reader = Files.newBufferedReader(Paths.get(pathToSshFile.toAbsolutePath().toString(), fileName))) {
                String currentTextRow;
                while ((currentTextRow = reader.readLine()) != null) {
                    readLines.add(currentTextRow);
                }
                map.put(fileName, readLines);
            } catch (IOException e) {
                throw new SshExtractorException(String.format("Exception during read content from %s", fileName), e.getCause());
            }
        }
        return map;
    }

    /**
     * Build list of file names by specific directory.
     *
     * @param directoryPath directory path using by {@link Path}.
     * @return list of file names.
     */
    List<String> fetchFileNamesBySpecificDirectory(Path directoryPath) {
        try (Stream<Path> stream = Files.list(directoryPath)) {
            List<String> fileNames = stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());

            if (fileNames.isEmpty()) {
                throw new SshExtractorException(String.format("None file names fetched from %s", directoryPath.toAbsolutePath()));
            }

            return fileNames;
        } catch (IOException e) {
            throw new SshExtractorException(String.format("Exception during fetch file names from %s", directoryPath.toAbsolutePath()), e.getCause());
        }
    }

    /**
     * Create a files by destination and contents.
     *
     * @param destination string based path where is need to save a files.
     * @param data        based as map where key is file name and value is a list with text contents row-by-row.
     * @return boolean flag is procedure finished successfully.
     */
    boolean writeSshData(String destination, Map<String, List<String>> data) {
        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            final String fileName = entry.getKey();

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(destination, entry.getKey()))) {
                for (String currentTextRow : entry.getValue()) {
                    writer.write(currentTextRow);
                    writer.newLine();
                }
            } catch (IOException e) {
                throw new SshExtractorException(String.format("Exception during write contents to '%s' file by '%s' path", fileName, destination),
                        e.getCause());
            }
        }
        return true;
    }
}