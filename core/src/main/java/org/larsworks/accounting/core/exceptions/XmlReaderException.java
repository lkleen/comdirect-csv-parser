package org.larsworks.accounting.core.exceptions;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:24
 */
public class XmlReaderException extends AccountDataAnalyzerIOException {
    public XmlReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
