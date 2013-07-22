package org.larsworks.comdirect.csv.parser;

import org.larsworks.comdirect.csv.io.TextFile;
import org.larsworks.comdirect.csv.io.TextFileReader;
import org.larsworks.comdirect.csv.model.AccountDataEntry;
import org.larsworks.comdirect.csv.model.AccountDataMetaData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.InputStream;
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
    public void init() {
        expected = new ArrayList<AccountDataEntry>();
        String entry0 = "21.05.2013 ;21.05.2013 ;Lastschrift Einzug;Auftraggeber: BLUMENLADEN Buchungstext: EC 60981180 170513155015OC0 Ref. 0RK13151D1555835/18675 ;-33,11";
        String entry1 = "17.05.2013 ;17.05.2013 ;Übertrag/Überweisung;Auftraggeber: HANS WURST GMBH Buchungstext: KONTO1118353611 B188605570 MUSTERSTRASSE 31 3.1 Ref. JG11313791816110/3013 ;33,12";
        String entry2 = "17.05.2013 ;17.05.2013 ;Auszahlung GAA;Buchungstext: GA NR06005867 BLZ70070075 0 16.05/13.71UHR HH-JUNGF.7 EUR     33,00 ENTGELT 0,00 Ref. 6AL13137A1351355/17958 ;-33,17";
        String entry3 = "17.05.2013 ;17.05.2013 ;Lastschrift Einzug;Auftraggeber: EPICBLA - SOMETHING Buchungstext: 0000100300804 0008573747339 ASDFASDF  110550709890 Ref. J3413136L5650368/37100 ;-33,12";
        String entry4 = "16.05.2013 ;16.05.2013 ;Übertrag/Überweisung;Auftraggeber: HEINZ Buchungstext: BUCHNR 40130515194153480615 AS-9105191077 ÜBERWEISUNG IHRES GUTHABENS COBADEHD055DE96400511550811 KDN-REF 01238712387 Ref. ID4131365234234/507 ;33,12";
        String entry5 = "15.05.2013 ;15.05.2013 ;Lastschrift Einzug;Auftraggeber: BLIBLABLUB Buchungstext: EC 60958305 140513414633OC0 Ref. 6LD1313551033344/5071 ;-33,12";
        expected.add(createEntry(entry0, -33.11f));
        expected.add(createEntry(entry1,  33.12f));
        expected.add(createEntry(entry2, -33.17f));
        expected.add(createEntry(entry3, -33.12f));
        expected.add(createEntry(entry4,  33.12f));
        expected.add(createEntry(entry5, -33.12f));
    }

    @Test
    public void test() throws Exception {
        InputStream testData = getClass().getClassLoader().getResourceAsStream("umsaetze_8115990_20130526-1520.testdata.csv");
        TextFile file = new TextFileReader(testData).call();
        List<AccountDataEntry> data = entryParser.parse(file);
        assertEquals(data, expected);
    }

    private AccountDataEntry createEntry(String line, float fluctuation) {
        String[] tokens = line.split(";");
        DateTimeParser parser = new DateTimeParser();
        return new AccountDataEntry(
            parser.parse(tokens[0]),
            parser.parse(tokens[1]),
                tokens[2],
                tokens[3],
                fluctuation
        );
    }

}
