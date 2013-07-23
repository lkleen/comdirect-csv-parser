package org.larsworks.comdirect.csv.parser;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.06.13
 *        Time: 16:51
 */
public class DateTimeParser {

    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    public DateTime parse(String string) {
        return formatter.parseDateTime(string.trim());
    }

}
