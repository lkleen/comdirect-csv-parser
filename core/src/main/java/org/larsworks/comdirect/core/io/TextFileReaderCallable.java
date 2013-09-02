package org.larsworks.comdirect.core.io;

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
public class TextFileReaderCallable implements Callable<TextFile> {

    private final InputStream inputStream;

    private final Charset charset;

    public TextFileReaderCallable(InputStream inputStream, Charset charset) {
        this.inputStream = inputStream;
        this.charset = charset;
    }

    @Override
    public TextFile call() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset.name()));
        TextLines textLines = new TextLines();
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null) {
            textLines.add(new TextLine(line));
            sb.append(line).append("\n");
        }
        return new TextFile(textLines, sb.toString());
    }
}
