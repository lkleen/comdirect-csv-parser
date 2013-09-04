package org.larsworks.accounting.core.io;

import javax.xml.bind.JAXB;
import java.io.InputStream;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:27
 */
public class XmlReader<T> {

    private final Class<T> clazz;

    public XmlReader(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T read(InputStream inputStream) {
        return JAXB.unmarshal(inputStream, clazz);
    }

}
