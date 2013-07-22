package org.larsworks.comdirect.csv.parser;

import org.larsworks.comdirect.csv.exceptions.TokenizerException;
import org.larsworks.comdirect.csv.io.TextLine;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 17:08
 */
public class Tokenizer {

    /**
     * tokenizes the line. currently implemented very simple based on splitting at ";". if it is getting more complex I
     * would use regular expressions instead
     *
     * @param line line to tokenize
     * @return
     */
    public List<String> tokenize(TextLine line) {
        List<String> tokens = new ArrayList<String>();
        for(String token : line.split("\";\"")) {
            if (token == null || token.length() == 0) {
                continue;
            }
            tokens.add(token.replace("\"", ""));
        }
        return tokens;
    }

}
