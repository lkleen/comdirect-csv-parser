package org.larsworks.accounting.core.exceptions;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:29
 */
public class TextFileReaderException extends AccountDataAnalyzerIOException {
    public TextFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
