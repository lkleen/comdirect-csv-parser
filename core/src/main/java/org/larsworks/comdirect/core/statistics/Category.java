package org.larsworks.comdirect.core.statistics;

import lombok.Data;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 17:33
 */
@Data
public class Category implements Comparable<Category> {

    private final String category;

    @Override
    public int compareTo(Category that) {
        return this.category.compareTo(that.category);
    }
}
