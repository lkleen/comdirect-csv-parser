package org.larsworks.accounting.core.exceptions;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 16:10
 */
public abstract class AccountDataAnalyzerException extends RuntimeException {
    public AccountDataAnalyzerException(String message) {
        super(message);
    }

    public AccountDataAnalyzerException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDataAnalyzerException(Throwable cause) {
        super(cause);
    }

    public AccountDataAnalyzerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
