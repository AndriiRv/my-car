package org.kent0k.sshextractor.exception;

public class SshExtractorException extends RuntimeException {

    public SshExtractorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SshExtractorException(String message) {
        super(message);
    }
}
