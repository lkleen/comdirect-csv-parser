package org.larsworks.accounting.core.statistics;

import lombok.Data;
import lombok.NonNull;
import org.joda.time.DateTime;

import java.util.SortedSet;

/**
 * Date: 7/25/13
 * Time: 5:55 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Data
public class AccountingPeriod implements Comparable<AccountingPeriod> {

    @NonNull
    final DateTime.Property month;

    @NonNull
    final SortedSet<Withdraw> withdraws;

    @NonNull
    final SortedSet<Deposit> deposits;

    @Override
    public int compareTo(AccountingPeriod that) {
        return this.month.getDateTime().compareTo(that.month.getDateTime());
    }

    @Override
    public String toString() {
        return month.toString();
    }
}
