package org.larsworks.accounting.core.io;

import org.larsworks.accounting.core.exceptions.FileHandlerException;

import java.io.*;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:36
 */
public class FileHandler {

    public OutputStream writeTo(String filename) {
        return writeTo(new File(filename));
    }

    public OutputStream writeTo(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return new FileOutputStream(file);
        } catch (Exception e) {
            throw new FileHandlerException("could not open file " + file.getAbsolutePath(), e);
        }
    }

    public InputStream readFrom(String filename) {
        return readFrom(new File(filename));
    }

    public InputStream readFrom(File file) {
        try {
            if(!file.exists()) {
                throw new FileHandlerException("file does not exist: " + file.getAbsolutePath());
            } else {
                return new FileInputStream(file);
            }
        } catch (Exception e) {
            throw new FileHandlerException("could not read from file " + file.getAbsolutePath(), e );
        }
    }




}
