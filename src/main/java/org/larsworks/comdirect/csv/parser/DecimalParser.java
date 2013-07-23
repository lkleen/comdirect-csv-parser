package org.larsworks.comdirect.csv.parser;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.larsworks.comdirect.csv.exceptions.DecimalParserException;

/**
 * Date: 7/23/13
 * Time: 11:01 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class DecimalParser {

    private static final String pattern = "#.##0,00;";

    private final NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMANY);

    public float  parse(String decimal) throws DecimalParserException {
        try {
            return format.parse(decimal).floatValue();
        } catch (ParseException e) {
            throw new DecimalParserException(e);
        }
    }

}
