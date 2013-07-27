package org.larsworks.comdirect.core.statistics;

import org.joda.time.DateTime;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 17:50
 */
public class Withdraw extends Fluctuation {
    public Withdraw(DateTime valueDate, float value) {
        super(valueDate, value);
    }
}
