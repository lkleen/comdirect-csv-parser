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
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            return new FileOutputStream(file);
        } catch (Exception e) {
            throw new FileHandlerException("could not open file " + filename, e);
        }
    }

    public InputStream readFrom(String filename) {
        try {
            File file = new File(filename);
            if(!file.exists()) {
                throw new FileHandlerException("file does not exist: " + filename);
            } else {
                return new FileInputStream(file);
            }
        } catch (Exception e) {
            throw new FileHandlerException("could not read from file " + filename, e );
        }
    }

}
