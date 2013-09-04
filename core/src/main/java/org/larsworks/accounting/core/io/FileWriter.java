package org.larsworks.accounting.core.io;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:21
 */
public class FileWriter {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * writes to file. not thread safe.
     * @param fileWriterCallable
     */
    public void write(FileWriterCallable fileWriterCallable) {
        executor.submit(fileWriterCallable);
    }

}
