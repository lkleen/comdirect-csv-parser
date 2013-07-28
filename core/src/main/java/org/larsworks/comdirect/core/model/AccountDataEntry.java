package org.larsworks.comdirect.core.model;

import lombok.Data;
import lombok.NonNull;
import org.joda.time.DateTime;
import org.larsworks.comdirect.core.statistics.Category;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:36
 */
@Data
public class AccountDataEntry implements Comparable<AccountDataEntry> {

    static long increment = 0;

    final long id = increment++;

    @NonNull
    final DateTime posting;

    @NonNull
    final DateTime valueDate;

    @NonNull
    final String process;

    @NonNull
    final String text;

    @NonNull
    final float fluctuation;

    Category category;

    @Override
    public int compareTo(AccountDataEntry that) {
        long value = this.valueDate.compareTo(that.valueDate);
        value = (value == 0) ? this.id - that.id : value;
        // TODO: might fail if id > Integer.MAX_VALUE
        return (int) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDataEntry)) return false;

        AccountDataEntry that = (AccountDataEntry) o;

        if (Float.compare(that.fluctuation, fluctuation) != 0) return false;
        if (!posting.equals(that.posting)) return false;
        if (!process.equals(that.process)) return false;
        if (!text.equals(that.text)) return false;
        if (!valueDate.equals(that.valueDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = posting.hashCode();
        result = 31 * result + valueDate.hashCode();
        result = 31 * result + process.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + (fluctuation != +0.0f ? Float.floatToIntBits(fluctuation) : 0);
        return result;
    }
}
