package org.larsworks.accounting.core.parser;

import org.larsworks.accounting.core.io.TextFile;
import org.larsworks.accounting.core.io.TextLine;
import org.larsworks.accounting.core.io.TextLines;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.06.13
 *        Time: 16:24
 */
public abstract class AbstractParser<T> {

    Tokenizer tokenizer = new Tokenizer();

    public T parse(TextFile file) {
        TextLines lines = file.getLines();
        T data = getInstance();
        for(TextLine line : lines) {
            fillResult(data, line);
        }
        return data;
    }

    protected abstract void fillResult(T data, TextLine line);

    protected abstract T getInstance();

}
