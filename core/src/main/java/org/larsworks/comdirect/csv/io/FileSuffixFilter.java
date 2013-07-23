package org.larsworks.comdirect.csv.io;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 16:12
 */
public abstract class FileSuffixFilter implements FileFilter {

    final String suffix;

    public FileSuffixFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getAbsolutePath().endsWith(suffix);
    }
}
