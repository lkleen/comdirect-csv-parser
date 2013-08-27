package org.larsworks.comdirect.gui.handler;

import java.util.concurrent.Callable;

/**
 * Date: 7/23/13
 * Time: 4:51 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public abstract class Handler<Source, Target> {

    public abstract void handle(final Source source, final Target target);

}
