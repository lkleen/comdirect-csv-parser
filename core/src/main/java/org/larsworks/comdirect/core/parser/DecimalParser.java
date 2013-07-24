package org.larsworks.comdirect.core.parser;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.larsworks.comdirect.core.exceptions.DecimalParserException;

/**
 * Date: 7/23/13
 * Time: 11:01 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class DecimalParser {

    private final NumberFormat format = NumberFormat.getNumberInstance(Locale.GERMANY);

    public float  parse(String decimal) throws DecimalParserException {
        try {
            decimal = decimal.replace("+","");
            return format.parse(decimal).floatValue();
        } catch (ParseException e) {
            throw new DecimalParserException(e);
        }
    }

}
