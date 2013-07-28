package org.larsworks.comdirect.gui.initializer;

/**
 * Date: 7/23/13
 * Time: 5:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public abstract class Initializer<T> {

    protected final T initializable;

    public Initializer(T initializable) {
        this.initializable = initializable;
    }

    public abstract void init();
}
