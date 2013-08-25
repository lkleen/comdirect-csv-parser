package org.larsworks.comdirect.core.exceptions;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:29
 */
public class TextFileReaderException extends CsvParserException {
    public TextFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
