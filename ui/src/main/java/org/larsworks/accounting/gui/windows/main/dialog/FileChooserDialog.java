package org.larsworks.accounting.gui.windows.main.dialog;

import javafx.stage.FileChooserBuilder;
import javafx.stage.Window;

import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 * Date: 28.08.13
 * Time: 19:20
 */
public class FileChooserDialog extends Dialog<File> {

    private final FileChooserBuilder builder;

    public FileChooserDialog(Window window) {
        super(window);
        builder = FileChooserBuilder.create();
        builder.title("choose import file");
    }

    @Override
    public File show() {
        return builder.build().showOpenDialog(window);
    }
}