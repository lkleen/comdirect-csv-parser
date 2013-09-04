package org.larsworks.accounting.core.statistics;

import org.joda.time.DateTime;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 17:51
 */
public class Deposit extends Fluctuation {
    public Deposit(DateTime valueDate, float value) {
        super(valueDate, value);
    }
}
