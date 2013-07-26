package org.larsworks.comdirect.core.statistics;

/**
 * Date: 7/26/13
 * Time: 10:08 AM
 *
 * @author lkleen
 * @version 0.0.1
 */
public interface Generator<T> {

    public Statistic<?> from(T data);

}
