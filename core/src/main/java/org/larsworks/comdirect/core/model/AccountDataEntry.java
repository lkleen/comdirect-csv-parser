package org.larsworks.comdirect.core.model;

import lombok.Data;
import org.joda.time.DateTime;
import org.larsworks.comdirect.core.statistics.Category;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:36
 */
@Data
public class AccountDataEntry {

    final DateTime posting;

    final DateTime valueDate;

    final String process;

    final String text;

    final float fluctuation;

    Category category;

}
