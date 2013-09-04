package org.larsworks.accounting.core.exceptions;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:23
 */
public abstract class AccountDataAnalyzerIOException extends AccountDataAnalyzerException {
    public AccountDataAnalyzerIOException(String message) {
        super(message);
    }

    public AccountDataAnalyzerIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDataAnalyzerIOException(Throwable cause) {
        super(cause);
    }

    public AccountDataAnalyzerIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
