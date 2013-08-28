package org.larsworks.comdirect.gui.initializer;

import javax.inject.Inject;

/**
 * Date: 7/23/13
 * Time: 5:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public abstract class Initializer<T> {

    @Inject
    protected T initializable;

    public abstract void init();

}
