package org.larsworks.comdirect.core.annotations.processor;

import lombok.Data;
import org.larsworks.comdirect.core.annotations.view.Column;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 19:02
 */
@Data
public class ColumnData {

    public static final int defaultWidth = 100;

    final String name;
    final int width;

    public ColumnData(Column column) {
        name = column.name();
        width = column.width();
    }

    public ColumnData(String name, int width) {
        this.name = name;
        this.width = width;
    }

    public ColumnData(String name) {
        this.name = name;
        this.width = defaultWidth;
    }
}
