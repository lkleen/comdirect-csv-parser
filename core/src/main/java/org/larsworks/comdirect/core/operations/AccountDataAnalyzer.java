package org.larsworks.comdirect.core.operations;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.parser.DecimalParser;

/**
 * Date: 7/24/13
 * Time: 4:33 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class AccountDataAnalyzer {

    private static final String KEY_INITIAL_VALUE = "Alter Kontostand";

    private final DecimalParser parser = new DecimalParser();

    private final AccountData accountData;

    public AccountDataAnalyzer(AccountData accountData) {
        this.accountData = accountData;
    }

    public float getInitialValue() {
        String value = accountData.getAccountDataMetaData().getMetaData().get(KEY_INITIAL_VALUE);
        if(value == null) {
            log.warn("could not parse initial value. returning 0");
            return 0F;
        } else {
            return parser.parse(value);
        }
    }

}
