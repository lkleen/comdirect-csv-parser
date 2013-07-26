package org.larsworks.comdirect.core.statistics;

import java.util.List;

import lombok.Data;

/**
 * Date: 7/25/13
 * Time: 1:35 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Data
public class AccountingData extends Statistic.Data {

    private List<AccountingPeriod> periods;

}
