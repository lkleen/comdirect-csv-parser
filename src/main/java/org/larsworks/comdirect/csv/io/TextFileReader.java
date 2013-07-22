package org.larsworks.comdirect.csv.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 15:57
 */
public class TextFileReader implements Callable<TextFile> {

    private final InputStream inputStream;

    public TextFileReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public TextFile call() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));
        TextLines textLines = new TextLines();
        String line = null;
        while((line = br.readLine()) != null) {
            textLines.add(new TextLine(line));
        }
        return new TextFile(textLines);
    }
}
