package org.larsworks.comdirect.core.annotations.view;

import org.larsworks.comdirect.core.annotations.processor.ColumnData;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 18:11
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    String name();

    int width() default ColumnData.DEFAULT_WIDTH;

    int order() default ColumnData.DEFAULT_ORDER;

}
