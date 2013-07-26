package org.larsworks.comdirect.core.statistics;

import org.larsworks.comdirect.core.model.AccountData;

/**
 * Date: 7/26/13
 * Time: 10:19 AM
 *
 * @author lkleen
 * @version version?
 */
public class AccountingStatisticsGenerator implements Generator<AccountingStatisticsData> {

    private final AccountData accountData;

    public AccountingStatisticsGenerator(AccountData accountData) {
        this.accountData = accountData;
    }

    @Override
    public AccountingStatisticsData generate() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
