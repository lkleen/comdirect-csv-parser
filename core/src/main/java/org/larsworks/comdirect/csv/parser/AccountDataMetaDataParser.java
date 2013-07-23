package org.larsworks.comdirect.csv.parser;

import org.larsworks.comdirect.csv.io.TextLine;
import org.larsworks.comdirect.csv.model.AccountDataMetaData;

import java.util.List;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 26.05.13
 *        Time: 17:00
 */
public class AccountDataMetaDataParser extends AbstractParser<AccountDataMetaData> {

    /**
     * if we have more than two tokens it is no metadata
     */
    private static final int MAX_METADATA_TOKENS = 2;

    private static final int KEY_INDEX   = 0;
    private static final int VALUE_INDEX = 1;

    @Override
    protected void fillResult(AccountDataMetaData metaData, TextLine line) {
        List<String> tokens = tokenizer.tokenize(line);
        if(tokens.size() <= MAX_METADATA_TOKENS) {
            if(tokens.size() == 1) {
                metaData.getMetaData().put(tokens.get(KEY_INDEX), null);
            } else if (tokens.size() == 2) {
                metaData.getMetaData().put(tokens.get(KEY_INDEX), tokens.get(VALUE_INDEX));
            }
        }
    }

    @Override
    protected AccountDataMetaData getInstance() {
        return new AccountDataMetaData();
    }

}
