package org.larsworks.accounting.core.exceptions;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:37
 */
public class FileHandlerException extends AccountDataAnalyzerIOException {
    public FileHandlerException(String message) {
        super(message);
    }

    public FileHandlerException(String message, Throwable cause) {
        super(message, cause);
    }
}
