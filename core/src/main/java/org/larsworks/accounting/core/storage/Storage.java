package org.larsworks.accounting.core.storage;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 19:54
 */
public interface Storage<T> {

    T load();

    void store(T t);

}
