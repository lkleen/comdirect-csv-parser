package org.larsworks.comdirect.core.io;

import lombok.Data;
import lombok.NonNull;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.concurrent.Callable;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:14
 */
@Data
public class FileWriterCallable implements Callable<Void> {

    @NonNull
    private final OutputStream outputStream;

    @NonNull
    private final String text;

    @Override
    public Void call() throws Exception {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write(text);
        writer.close();
        return null;
    }
}
