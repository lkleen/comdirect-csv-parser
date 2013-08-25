package org.larsworks.comdirect.core.controllers;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.core.model.AccountData;

/**
 * Date: 7/24/13
 * Time: 2:22 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class AccountDataMerger {

    /**
     * merges multiple account data
     * @param list list of account data instances. eg. parsed from different csv files
     * @return merged list
     */
    public AccountData merge(List<AccountData> list) {
        log.warn("NOT IMPLEMENTED. Always returns first element of the list");
        return list.get(0);
    }

}
