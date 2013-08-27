package org.larsworks.comdirect.core.parser;

import org.larsworks.comdirect.core.io.TextFile;
import org.larsworks.comdirect.core.model.AccountData;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

/**
 * Date: 7/23/13
 * Time: 11:27 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataParser {

    @Inject
    private AccountDataMetaDataParser metaDataParser;

    @Inject
    private AccountDataEntryParser entryParser;

    public AccountData parse(TextFile textFile) {
        AccountData accountData = new AccountData();
        accountData.setAccountDataMetaData(metaDataParser.parse(textFile));
        accountData.setAccountDataEntries(entryParser.parse(textFile));
        return accountData;
    }

}
