package org.larsworks.accounting.core.io;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 04.09.13
 *        Time: 19:30
 */
public class XmlIO<T> {

    private final XmlReader<T> reader;
    private final XmlWriter<T> writer;

    public XmlIO(Class<T> clazz) {
        reader = new XmlReader<T>(clazz);
        writer = new XmlWriter<>();
    }

    public XmlReader<T> reader() {
        return reader;
    }

    public XmlWriter<T> writer() {
        return writer;
    }

}
