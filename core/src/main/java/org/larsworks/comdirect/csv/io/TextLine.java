package org.larsworks.comdirect.csv.io;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: lars
 * Date: 26.05.13
 * Time: 15:50
 */
@Data
public class TextLine {
    private final String text;

    public String[] split(String regex) {
        return text.split(regex);
    }

}
