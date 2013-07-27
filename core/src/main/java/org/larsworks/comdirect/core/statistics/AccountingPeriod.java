package org.larsworks.comdirect.core.statistics;

import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
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

    @NotNull
    final DateTime.Property month;

    @NotNull
    final SortedSet<Withdraw> withdraws;

    @NotNull
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
