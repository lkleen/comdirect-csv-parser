package org.larsworks.comdirect.gui.windows.main.dialog;

import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Window;

import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 28.07.13
 *        Time: 12:34
 */
public class DirectoryChooserDialog extends Dialog<File> {

    private final DirectoryChooserBuilder builder;

    public DirectoryChooserDialog(Window window) {
        super(window);
        builder = DirectoryChooserBuilder.create();
        builder.title("choose import directory");
    }

    @Override
    public File show() {
        return builder.build().showDialog(window);
    }
}
