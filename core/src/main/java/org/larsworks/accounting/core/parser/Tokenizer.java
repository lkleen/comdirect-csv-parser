package org.larsworks.accounting.core.parser;

import org.larsworks.accounting.core.io.TextLine;

import java.util.*;

/**
 * @author Lars Kleen
 * @since 0.0.1
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
