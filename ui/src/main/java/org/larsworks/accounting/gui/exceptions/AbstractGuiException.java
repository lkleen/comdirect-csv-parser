package org.larsworks.accounting.gui.exceptions;

import org.larsworks.accounting.core.exceptions.AccountDataAnalyzerException;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 13:33
 */
public abstract class AbstractGuiException extends AccountDataAnalyzerException {
    public AbstractGuiException(String message) {
        super(message);
    }

    public AbstractGuiException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractGuiException(Throwable cause) {
        super(cause);
    }

    public AbstractGuiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
