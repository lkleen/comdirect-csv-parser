package org.larsworks.comdirect.core.parser;

import org.joda.time.DateTime;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.model.AccountDataEntry;
import org.larsworks.comdirect.core.statistics.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 20:51
 */
public class AccountingStatisticsDataGeneratorTest {

    private AccountingStatisticsData expected;
    private AccountingStatisticsGenerator generator;

    @BeforeTest
    public void beforeTest() {
        generator = new AccountingStatisticsGenerator(generateAccountData());
        expected  = generateExpected();
    }

    @Test
    public void test() {
        AccountingStatisticsData test = generator.generate();
        assertEquals(generator.generate(), expected);
    }


    private AccountingStatisticsData generateExpected() {
        AccountingStatisticsData expected = new AccountingStatisticsData();
        SortedSet<AccountingPeriod> periods = new TreeSet<AccountingPeriod>();

        AccountingPeriod period01 = new AccountingPeriod(december2012().monthOfYear(), new TreeSet<Withdraw>(), new TreeSet<Deposit>());
        AccountingPeriod period02 = new AccountingPeriod(january2013().monthOfYear(), new TreeSet<Withdraw>(), new TreeSet<Deposit>());

        periods.add(period01);
        periods.add(period02);

        period01.getDeposits().add(new Deposit(december2012(), 2F));
        period01.getWithdraws().add(new Withdraw(december2012(), -1F));

        period02.getDeposits().add(new Deposit(january2013(), 2F));
        period02.getWithdraws().add(new Withdraw(january2013(), -1F));

        expected.setPeriods(periods);

        return expected;
    }

    private AccountData generateAccountData() {
        AccountData data = new AccountData();
        data.setAccountDataEntries(generateAccountDataEntries());
        return data;
    }

    private List<AccountDataEntry> generateAccountDataEntries() {
        List<AccountDataEntry> entries = new ArrayList<AccountDataEntry>();
        entries.add(newEntry(december2012(), -1F));
        entries.add(newEntry(december2012(),  2F));
        entries.add(newEntry(january2013(),  -1F));
        entries.add(newEntry(january2013(),   2F));
        return entries;
    }

    private DateTime december2012() {
        return new DateTime(2012, 12, 31, 23, 59, 59);
    }

    private DateTime january2013() {
        return new DateTime(2013, 01, 01, 00, 00, 00);
    }

    private AccountDataEntry newEntry(DateTime valueDate, float fluctuation) {
        return new AccountDataEntry(null, valueDate, "", "", fluctuation);
    }
}
