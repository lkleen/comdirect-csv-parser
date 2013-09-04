package org.larsworks.accounting.core.controllers;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.model.AccountData;
import org.larsworks.accounting.core.parser.SimpleDecimalParser;

import javax.inject.Inject;

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

    @Inject
    private SimpleDecimalParser parser;

    public float getInitialValueFrom(AccountData accountData) {
        String value = accountData.getAccountDataMetaData().getMetaData().get(KEY_INITIAL_VALUE);
        if(value == null) {
            log.warn("could not parse initial value. returning 0");
            return 0F;
        } else {
            return parser.parse(value);
        }
    }

}
