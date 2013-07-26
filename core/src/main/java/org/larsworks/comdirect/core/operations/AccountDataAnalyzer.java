package org.larsworks.comdirect.core.operations;

import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.parser.DecimalParser;

/**
 * Date: 7/24/13
 * Time: 4:33 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataAnalyzer {

    private static final String KEY_INITIAL_VALUE = "Alter Kontostand";

    private final DecimalParser parser = new DecimalParser();

    private final AccountData accountData;

    public AccountDataAnalyzer(AccountData accountData) {
        this.accountData = accountData;
    }

    public float getInitialValue() {
        String value = accountData.getAccountDataMetaData().getMetaData().get(KEY_INITIAL_VALUE);
        return parser.parse(value);
    }

}
