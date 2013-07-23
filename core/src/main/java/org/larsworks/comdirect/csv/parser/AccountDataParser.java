package org.larsworks.comdirect.csv.parser;

import org.larsworks.comdirect.csv.io.TextFile;
import org.larsworks.comdirect.csv.model.AccountData;

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

    public AccountData parser(TextFile textFile) {
        AccountData accountData = new AccountData();
        accountData.setAccountDataMetaData(metaDataParser.parse(textFile));
        accountData.setAccountDataEntries(entryParser.parse(textFile));
        return accountData;
    }

}
