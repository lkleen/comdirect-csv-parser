package org.larsworks.comdirect.core.io;

import org.larsworks.comdirect.core.exceptions.TextFileReaderException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:27
 */
public class TextFileReader {

    public TextFile read(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            TextFileReaderCallable textFileReader = new TextFileReaderCallable(fis);
            return textFileReader.call();
        } catch (Exception e) {
            throw new TextFileReaderException("could not read: " + filename, e);
        }
    }

}
