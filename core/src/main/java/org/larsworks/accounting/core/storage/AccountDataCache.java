package org.larsworks.accounting.core.storage;

import lombok.Data;
import org.larsworks.accounting.core.model.AccountData;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 20:55
 *
 *        holds non persistent account data.
 */
@Data
public class AccountDataCache {

    private AccountData accountData;

}
