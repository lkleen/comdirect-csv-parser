package org.larsworks.comdirect.csv.io;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.comdirect.csv.exceptions.DirectoryReaderException;
import sun.nio.ch.ThreadPool;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 16:04
 */
@Slf4j
public class DirReader {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public List<TextFile> readDir(String source, FileFilter fileFilter) {
        File dir = new File(source);
        if (!dir.isDirectory()) {
            throw new DirectoryReaderException(source + " is no directory");
        }
        return readParallel(dir.listFiles(fileFilter));
    }

    private List<TextFile> readParallel(File... files) {
        List<Future<TextFile>> futures = new ArrayList<Future<TextFile>>();
        List<TextFile> result = new ArrayList<TextFile>();
        for (File file : files) {
            try {
                TextFileReader reader = new TextFileReader(new FileInputStream(file));
                futures.add(executor.submit(reader));
            } catch (FileNotFoundException e) {
                log.error("could not read {}", file, e);
            }
        }
        for(Future<TextFile> future : futures) {
            try {
                result.add(future.get());
            } catch (Exception e) {
                throw new DirectoryReaderException(e);
            }
        }
        return result;
    }
}
