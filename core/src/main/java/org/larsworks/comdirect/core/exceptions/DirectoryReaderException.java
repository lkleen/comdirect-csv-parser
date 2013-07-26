package org.larsworks.comdirect.core.exceptions;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 16:10
 */
public class DirectoryReaderException extends CsvParserException {
    public DirectoryReaderException(String message) {
        super(message);
    }

    public DirectoryReaderException(Throwable cause) {
        super(cause);
    }
}
