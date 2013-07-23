package org.larsworks.comdirect.csv.parser;


import lombok.extern.slf4j.Slf4j;
import org.larsworks.comdirect.csv.io.TextLine;
import org.larsworks.comdirect.csv.model.AccountDataEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 17:00
 */
@Slf4j
public class AccountDataEntryParser extends AbstractParser<List<AccountDataEntry>> {

    /**
     * number of tokens for account data entries
     */
    private static final int NUM_ENTRY_TOKENS = 5;

    private static final int INDEX_POSTING     = 0;
    private static final int INDEX_VALUE_DATE  = 1;
    private static final int INDEX_PROCESS     = 2;
    private static final int INDEX_TEXT        = 3;
    private static final int INDEX_FLUCTUATION = 4;

    private final DateTimeParser dateTimeParser = new DateTimeParser();
    private final DecimalParser decimalParser = new DecimalParser();

    @Override
    protected void fillResult(List<AccountDataEntry> data, TextLine line) {
        List<String> tokens = tokenizer.tokenize(line);
        if(tokens.size() == NUM_ENTRY_TOKENS) {
            try {
                AccountDataEntry entry = new AccountDataEntry(
                        dateTimeParser.parse(tokens.get(INDEX_POSTING)),
                        dateTimeParser.parse(tokens.get(INDEX_VALUE_DATE)),
                        tokens.get(INDEX_PROCESS),
                        tokens.get(INDEX_TEXT),
                        decimalParser.parse(tokens.get(INDEX_FLUCTUATION))
                );

                data.add(entry);
            } catch (Exception e) {
                AccountDataEntryParser.log.debug("could not parse line: " + line);
                AccountDataEntryParser.log.trace("stacktrace: ", e);
            }
        }
    }

    @Override
    protected List<AccountDataEntry> getInstance() {
        return new ArrayList<AccountDataEntry>();
    }
}
