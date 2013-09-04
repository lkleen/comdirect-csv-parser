package org.larsworks.accounting.core.annotations.processor;

import lombok.Data;
import org.larsworks.accounting.core.annotations.view.Column;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 19:02
 */
@Data
public class ColumnData implements Comparable<ColumnData> {

    public static final int DEFAULT_WIDTH = 100;

    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;

    final String name;
    final int width;
    final int order;

    public ColumnData(Column column) {
        name = column.name();
        width = column.width();
        order = column.order();
    }

    public ColumnData(String name, int width, int order) {
        this.name = name;
        this.width = width;
        this.order = order;
    }

    public ColumnData(String name) {
        this.name = name;
        this.width = DEFAULT_WIDTH;
        this.order = DEFAULT_ORDER;
    }

    @Override
    public int compareTo(ColumnData that) {
        int value = this.order - that.order;
        return (value == 0) ? this.name.compareTo(that.name) : value;
    }
}
