package org.larsworks.comdirect.core.exceptions;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 16:10
 */
public abstract class CsvParserException extends RuntimeException {
    public CsvParserException(String message) {
        super(message);
    }

    public CsvParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsvParserException(Throwable cause) {
        super(cause);
    }

    public CsvParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
