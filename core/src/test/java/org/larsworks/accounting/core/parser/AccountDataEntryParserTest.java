package org.larsworks.accounting.core.parser;

import org.larsworks.accounting.core.io.TextFile;
import org.larsworks.accounting.core.io.TextFileReaderCallable;
import org.larsworks.accounting.core.io.TextLine;
import org.larsworks.accounting.core.model.AccountDataEntry;
import org.larsworks.accounting.core.test.AbstractCoreTest;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.06.13
 *        Time: 17:47
 */
public class AccountDataEntryParserTest extends AbstractCoreTest {

    private static final String CHARSET = "ISO-8859-1";

    @Inject
    AccountDataEntryParser entryParser;

    @Inject
    SimpleDateTimeParser parser;

    @Inject
    NumberFormat format;

    private List<AccountDataEntry> expected;

    @PostConstruct
    public void init() throws Exception {
        expected = new ArrayList<AccountDataEntry>();
        TextFileReaderCallable tfr =
                new TextFileReaderCallable(
                        getClass().getClassLoader().getResourceAsStream("expected_account_entries.csv"),
                        Charset.forName(CHARSET)
                );
        TextFile file = tfr.call();
        for(TextLine line :file.getLines()) {
            if (line.getText() != null && line.getText().length() > 0) {
                expected.add(createEntry(line));
            }
        }
    }

    @Test
    public void test() throws Exception {
        InputStream testData = getClass().getClassLoader().getResourceAsStream("umsaetze_8115990_20130526-1520.testdata.csv");
        TextFile file = new TextFileReaderCallable(testData, Charset.forName(CHARSET)).call();
        Set<AccountDataEntry> data = entryParser.parse(file);
        assertEquals(data, expected);
    }

    private AccountDataEntry createEntry(TextLine line) throws Exception {
        String[] tokens = line.split(";");
        for(int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].replaceAll("\"", "");
        }
        return new AccountDataEntry(
                parser.parse(tokens[0]),
                parser.parse(tokens[1]),
                tokens[2],
                tokens[3],
                format.parse(tokens[4]).floatValue()
        );
    }

}
