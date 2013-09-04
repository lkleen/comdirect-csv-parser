package org.larsworks.accounting.core.io;

import lombok.Setter;
import org.larsworks.accounting.core.exceptions.TextFileReaderException;

import java.io.FileInputStream;
import java.nio.charset.Charset;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:27
 */
public class TextFileReader {

    @Setter
    private Charset charset = Charset.defaultCharset();

    public TextFile read(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            TextFileReaderCallable textFileReader = new TextFileReaderCallable(fis, charset);
            return textFileReader.call();
        } catch (Exception e) {
            throw new TextFileReaderException("could not read: " + filename, e);
        }
    }

}
