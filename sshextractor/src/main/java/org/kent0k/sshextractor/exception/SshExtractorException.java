package org.kent0k.sshextractor.exception;

import org.slf4j.Logger;

public class SshExtractorException extends RuntimeException {

    public SshExtractorException(String message, Throwable cause, Logger logger) {
        super(message, cause);

        logger.error(message, this);
    }
}
