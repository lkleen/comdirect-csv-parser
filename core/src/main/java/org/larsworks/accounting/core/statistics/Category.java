package org.larsworks.accounting.core.statistics;

import lombok.Data;
import org.larsworks.accounting.core.annotations.view.Column;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 17:33
 */
@Data
public class Category implements Comparable<Category> {

    @Column(name = "Category", width = 250)
    private final String category;

    @Override
    public int compareTo(Category that) {
        return this.category.compareTo(that.category);
    }

    @Override
    public String toString() {
        return category;
    }
}
