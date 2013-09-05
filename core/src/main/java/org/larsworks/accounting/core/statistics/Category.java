package org.larsworks.accounting.core.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.larsworks.accounting.core.annotations.view.Column;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 17:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Comparable<Category> {

    @Column(name = "Category", width = 250)
    private String category;

    @Override
    public int compareTo(Category that) {
        return this.category.compareTo(that.category);
    }

    @Override
    public String toString() {
        return category;
    }
}
