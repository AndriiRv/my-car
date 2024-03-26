package org.kent0k.sshextractor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SshExtractorMultithreadServiceImpl implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(SshExtractorMultithreadServiceImpl.class);

    private String fileName;

    private String pathToSshFile;

    private String projectSshDirectoryPath;

    private final SshExtractorServiceImpl sshExtractorService;

    public SshExtractorMultithreadServiceImpl(SshExtractorServiceImpl sshExtractorService) {
        this.sshExtractorService = sshExtractorService;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPathToSshFile(String pathToSshFile) {
        this.pathToSshFile = pathToSshFile;
    }

    public void setProjectSshDirectoryPath(String projectSshDirectoryPath) {
        this.projectSshDirectoryPath = projectSshDirectoryPath;
    }

    @Override
    public void run() {
        LOG.debug(String.format("Start thread %s to read from %s : %s and write to %s", Thread.currentThread().getName(), pathToSshFile, fileName, projectSshDirectoryPath));
        sshExtractorService.readAndWriteSshData(pathToSshFile, fileName, projectSshDirectoryPath);
        LOG.debug(String.format("End thread %s to read from %s : %s and write to %s", Thread.currentThread().getName(), pathToSshFile, fileName, projectSshDirectoryPath));
    }
}
