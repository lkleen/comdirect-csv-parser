package org.larsworks.comdirect.csv.parser;

import org.larsworks.comdirect.csv.io.TextFile;
import org.larsworks.comdirect.csv.io.TextLine;
import org.larsworks.comdirect.csv.io.TextLines;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.06.13
 *        Time: 16:24
 */
public abstract class AbstractParser<T> {

    Tokenizer tokenizer = new Tokenizer();

    public T parse(TextFile file) {
        TextLines lines = file.getTextLines();
        T data = getInstance();
        for(TextLine line : lines) {
            fillResult(data, line);
        }
        return data;
    }

    protected abstract void fillResult(T data, TextLine line);

    protected abstract T getInstance();

}
