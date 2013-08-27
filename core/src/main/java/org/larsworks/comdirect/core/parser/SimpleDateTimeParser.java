package org.larsworks.comdirect.core.parser;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Inject;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.06.13
 *        Time: 16:51
 */
public class SimpleDateTimeParser {

    @Inject
    private DateTimeFormatter formatter;

    public DateTime parse(String string) {
        return formatter.parseDateTime(string.trim());
    }

}
