package org.larsworks.comdirect.core.statistics;

import org.joda.time.DateTime;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.model.AccountDataEntry;

import java.util.*;

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
        return generateAccountingStatisticsDataFrom(accountData.getAccountDataEntries());
    }

    private AccountingStatisticsData generateAccountingStatisticsDataFrom(List<AccountDataEntry> entries) {
        Map<DateTime.Property, AccountingPeriod> periods = new HashMap<DateTime.Property, AccountingPeriod>();
        for(AccountDataEntry entry : entries) {
            DateTime.Property month = entry.getValueDate().monthOfYear();
            AccountingPeriod period = periods.get(month);
            period = (period == null) ? new AccountingPeriod(month, new TreeSet<Withdraw>(), new TreeSet<Deposit>()) : period;
            periods.put(month, period);
            if(entry.getFluctuation() < 0) {
                period.getWithdraws().add(new Withdraw(entry.getValueDate(), entry.getFluctuation()));
            } else {
                period.getDeposits().add(new Deposit(entry.getValueDate(), entry.getFluctuation()));
            }
        }
        AccountingStatisticsData data = new AccountingStatisticsData();
        data.setPeriods(new TreeSet<AccountingPeriod>(periods.values()));
        return data;
    }

}
