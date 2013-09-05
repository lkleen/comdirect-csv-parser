package org.larsworks.accounting.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.joda.time.DateTime;
import org.larsworks.accounting.core.annotations.view.Column;
import org.larsworks.accounting.core.annotations.view.Ignore;
import org.larsworks.accounting.core.statistics.Category;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 26.05.13
 *        Time: 16:36
 *        TODO: add and process ignore annotation for fields not related to the entry data
 */
@Data
public class AccountDataEntry implements Comparable<AccountDataEntry> {

    @Ignore
    static long increment = 0;

    @Ignore
    final long id = increment++;

    @NonNull
    @Column(name = "Posting", order = 0)
    DateTime posting;

    @NonNull
    @Column(name = "Value Date", order = 1)
    DateTime valueDate;

    @NonNull
    @Column(name = "Process", order = 2)
    String process;

    @NonNull
    @Column(name = "Text", order = 3)
    String text;

    @NonNull
    @Column(name = "Fluctuation", order = 4)
    float fluctuation;

    @Column(name = "Category", order = 5)
    Category category;

    public AccountDataEntry() {
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        sb
                .append(format.format(fluctuation))
                .append(" | ")
                .append(text);
        return sb.toString();
    }
}
