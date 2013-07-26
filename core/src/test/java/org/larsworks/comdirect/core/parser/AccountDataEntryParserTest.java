package org.larsworks.comdirect.core.parser;

import org.larsworks.comdirect.core.io.TextFile;
import org.larsworks.comdirect.core.io.TextFileReader;
import org.larsworks.comdirect.core.io.TextLine;
import org.larsworks.comdirect.core.model.AccountDataEntry;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.06.13
 *        Time: 17:47
 */
public class AccountDataEntryParserTest {

    private final AccountDataEntryParser entryParser = new AccountDataEntryParser();

    private List<AccountDataEntry> expected;

    @BeforeTest
    public void init() throws Exception {
        expected = new ArrayList<AccountDataEntry>();
        TextFileReader tfr = new TextFileReader(getClass().getClassLoader().getResourceAsStream("expected_account_entries.csv"));
        TextFile file = tfr.call();
        for(TextLine line :file.getTextLines()) {
            if (line.getText() != null && line.getText().length() > 0) {
                expected.add(createEntry(line));
            }
        }
    }

    @Test
    public void test() throws Exception {
        InputStream testData = getClass().getClassLoader().getResourceAsStream("umsaetze_8115990_20130526-1520.testdata.csv");
        TextFile file = new TextFileReader(testData).call();
        List<AccountDataEntry> data = entryParser.parse(file);
        assertEquals(data, expected);
    }

    private AccountDataEntry createEntry(TextLine line) throws Exception {
        String[] tokens = line.split(";");
        for(int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replaceAll("\"", "");
        }
        DateTimeParser parser = new DateTimeParser();
        NumberFormat format = new DecimalFormat();
        return new AccountDataEntry(
                parser.parse(tokens[0]),
                parser.parse(tokens[1]),
                tokens[2],
                tokens[3],
                format.parse(tokens[4]).floatValue()
        );
    }

}
