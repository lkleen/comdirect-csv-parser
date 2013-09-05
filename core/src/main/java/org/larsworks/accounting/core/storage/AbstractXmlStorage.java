package org.larsworks.accounting.core.storage;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.io.FileHandler;
import org.larsworks.accounting.core.io.XmlIO;

import javax.inject.Inject;
import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 19:56
 */
@Slf4j
public abstract class AbstractXmlStorage<T> implements Storage<T> {

    private File file;

    @Inject
    public FileHandler fileHandler;

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public T load() {
        try {
            return getXmlIO().reader().read(fileHandler.readFrom(file));
        } catch (Exception e) {
            log.info("could not read from file " + file + " new configuration file created");
            return emptyInstance();
        }
    }

    @Override
    public void store(T data) {
        getXmlIO().writer().write(fileHandler.writeTo(file), data);
    }

    protected abstract XmlIO<T> getXmlIO();

    protected abstract T emptyInstance();
}
