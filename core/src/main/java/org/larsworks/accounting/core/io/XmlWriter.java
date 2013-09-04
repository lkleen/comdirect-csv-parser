package org.larsworks.accounting.core.io;

import javax.xml.bind.JAXB;
import java.io.*;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:17
 */
public class XmlWriter<T> {

    public void write(OutputStream outputStream, T data) {
        JAXB.marshal(data, outputStream);
    }

}
