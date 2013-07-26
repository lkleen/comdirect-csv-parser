package org.larsworks.comdirect.core.statistics;

import org.larsworks.comdirect.core.model.AccountData;

/**
 * Date: 7/25/13
 * Time: 1:41 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountingStatistic extends Statistic<AccountingStatisticsData> {

    private final AccountData accountData;

    public AccountingStatistic(AccountData accountData) {
        this.accountData = accountData;
    }

    @Override
    public Generator<AccountingStatisticsData> generator() {
        return new AccountingStatisticsGenerator(accountData);
    }
}
