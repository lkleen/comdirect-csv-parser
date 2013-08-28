package org.larsworks.comdirect.gui.windows.main.dialog;

import javafx.stage.Window;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 28.07.13
 *        Time: 12:34
 */
public abstract class Dialog<T> {

    protected final Window window;

    protected Dialog(Window window) {
        this.window = window;
    }

    public abstract T show();

}
