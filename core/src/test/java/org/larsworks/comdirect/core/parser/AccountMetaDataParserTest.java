package org.larsworks.comdirect.core.parser;

import org.larsworks.comdirect.core.io.TextFile;
import org.larsworks.comdirect.core.io.TextFileReaderCallable;
import org.larsworks.comdirect.core.model.AccountDataMetaData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.06.13
 *        Time: 15:54
 */
public class AccountMetaDataParserTest {

    private final AccountDataMetaDataParser accountDataMetaDataParser = new AccountDataMetaDataParser();

    private final Map<String, String> expected = new HashMap<String, String>();

    @BeforeTest
    public void init() {
        expected.put("comdirect bank AG", null);
        expected.put("UMS&Auml;TZE: PATER FRITZ", null);
        expected.put("Erstellt am: 26.05.2013, 15:20 Uhr", null);
        expected.put("Kunden-Nummer:", "1231230");
        expected.put("BLZ:", "20041144");
        expected.put("Verfügbarer Betrag:", "2.234,67 EUR");
        expected.put("Kontostand:", "+2.1234,56 EUR");
        expected.put("Ums&auml;tze Girokonto", " - Zeitraum: 30 Tage");
        expected.put("Neuer Kontostand", "+2.1234,56");
        expected.put("Alter Kontostand", "+1.234,56");
    }

    @Test
    public void test() throws Exception {
        InputStream testData = getClass().getClassLoader().getResourceAsStream("umsaetze_8115990_20130526-1520.testdata.csv");
        TextFile file = new TextFileReaderCallable(testData).call();
        AccountDataMetaData data = accountDataMetaDataParser.parse(file);
        assertEquals(data.getMetaData(), expected);
    }

}
