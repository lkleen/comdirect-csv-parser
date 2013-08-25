package org.larsworks.comdirect.gui.windows.main.dialog;

import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Window;

import java.io.File;

/**
 * @author Lars Kleen
 * @since ?version
 *        Date: 28.07.13
 *        Time: 12:34
 */
public class DirectoryChooserDialog extends Dialog<File> {

    private final DirectoryChooserBuilder builder;
    private final Window window;

    public DirectoryChooserDialog(Window window) {
        this.window = window;
        builder = DirectoryChooserBuilder.create();
        builder.title("choose import directory");
    }

    @Override
    public File show() {
        return builder.build().showDialog(window);
    }
}
