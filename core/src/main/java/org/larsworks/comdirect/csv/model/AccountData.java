package org.larsworks.comdirect.csv.model;

import lombok.Data;

import java.util.List;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:36
 */
@Data
public class AccountData {

    AccountDataMetaData accountDataMetaData;

    List<AccountDataEntry> accountDataEntries;

}
