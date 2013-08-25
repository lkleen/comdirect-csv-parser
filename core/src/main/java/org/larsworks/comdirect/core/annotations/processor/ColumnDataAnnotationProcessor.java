package org.larsworks.comdirect.core.annotations.processor;

import org.larsworks.comdirect.core.annotations.view.Column;
import org.larsworks.comdirect.core.annotations.view.Ignore;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 18:55
 */
public class ColumnDataAnnotationProcessor<T> {

    public Map<Field, ColumnData> process(Class<T> clazz) {
        Map<Field, ColumnData> map = new HashMap<Field, ColumnData>();
        for (Field field : clazz.getDeclaredFields()) {
            if(field.isAnnotationPresent(Ignore.class)) {
                continue;
            } else {
                Column column = field.getAnnotation(Column.class);
                if(column != null) {
                    map.put(field, new ColumnData(column));
                } else {
                    map.put(field, new ColumnData(field.getName()));
                }
            }
        }
        return map;
    }

}
