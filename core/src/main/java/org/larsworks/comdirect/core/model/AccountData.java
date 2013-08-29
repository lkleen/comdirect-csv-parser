package org.larsworks.comdirect.core.model;

import lombok.Data;

import java.util.SortedSet;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:36
 */
@Data
public class AccountData {

    AccountDataMetaData accountDataMetaData;

    SortedSet<AccountDataEntry> accountDataEntries;

}
