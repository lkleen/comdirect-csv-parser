package org.larsworks.comdirect.core.parser;

import org.larsworks.comdirect.core.io.TextFile;
import org.larsworks.comdirect.core.model.AccountData;

/**
 * Date: 7/23/13
 * Time: 11:27 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataParser {

    private final AccountDataMetaDataParser metaDataParser = new AccountDataMetaDataParser();
    private final AccountDataEntryParser entryParser = new AccountDataEntryParser();

    public AccountData parse(TextFile textFile) {
        AccountData accountData = new AccountData();
        accountData.setAccountDataMetaData(metaDataParser.parse(textFile));
        accountData.setAccountDataEntries(entryParser.parse(textFile));
        return accountData;
    }

}
