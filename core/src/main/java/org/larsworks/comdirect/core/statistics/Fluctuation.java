package org.larsworks.comdirect.core.statistics;

import lombok.NonNull;
import org.joda.time.DateTime;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 17:25
 */
public abstract class Fluctuation implements Comparable<Fluctuation> {

    @NonNull
    final DateTime valueDate;

    final float value;

    Category category;

    public Fluctuation(DateTime valueDate, float value) {
        this.valueDate = valueDate;
        this.value = value;
    }

    @Override
    public int compareTo(Fluctuation that) {
        if (this.category == null) {
            return -1;
        }
        int val = this.category.compareTo(that.category);
        if (val == 0) {
            return valueDate.compareTo(that.valueDate);
        } else {
            return val;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fluctuation)) return false;

        Fluctuation that = (Fluctuation) o;

        if (Float.compare(that.value, value) != 0) return false;
        if (!category.equals(that.category)) return false;
        if (!valueDate.equals(that.valueDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = valueDate.hashCode();
        result = 31 * result + (value != +0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + category.hashCode();
        return result;
    }
}
