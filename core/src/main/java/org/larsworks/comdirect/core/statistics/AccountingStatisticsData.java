package org.larsworks.comdirect.core.statistics;

import java.util.List;
import java.util.SortedSet;

import lombok.Data;

/**
 * Date: 7/25/13
 * Time: 1:35 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Data
public class AccountingStatisticsData extends Statistic.Data {

    private SortedSet<AccountingPeriod> periods;

}
