package org.larsworks.accounting.core.annotations.processor;

import org.larsworks.accounting.core.annotations.view.Column;
import org.larsworks.accounting.core.annotations.view.Ignore;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 18:55
 */
public class ColumnDataAnnotationProcessor<T> {

    public Map<ColumnData, Field> process(Class<T> clazz) {
        Map<ColumnData, Field> map = new TreeMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            if(field.isAnnotationPresent(Ignore.class)) {
                continue;
            } else {
                Column column = field.getAnnotation(Column.class);
                if(column != null) {
                    map.put(new ColumnData(column), field);
                } else {
                    map.put(new ColumnData(field.getName()), field);
                }
            }
        }
        return map;
    }

}
