package org.larsworks.accounting.core.parser;

import org.larsworks.accounting.core.io.TextLine;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 17:15
 */
public class TokenizerTest {

    private Map<String, String> expected;

    private final Tokenizer tokenizer = new Tokenizer();

    @Test
    public void test() {
        List<String> actual;

        actual = tokenizer.tokenize(new TextLine("\"comdirect bank AG\""));
        assertEquals(actual, expected("comdirect bank AG"));

        actual = tokenizer.tokenize(new TextLine("\"Kunden-Nummer:\";\"1231230\""));
        assertEquals(actual, expected("Kunden-Nummer:","1231230"));

        actual = tokenizer.tokenize(new TextLine("\"string;with;\";\"1231230\""));
        assertEquals(actual, expected("string;with;","1231230"));
    }

    public List<String> expected(String... strings) {
        List<String> expected = new ArrayList<String>();
        for(String string : strings) {
            expected.add(string);
        }
        return expected;
    }

}
