package org.larsworks.accounting.gui.windows.main.dialog;

import javafx.stage.Window;

import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 20:24
 */
public class FileOpenDialog extends FileChooserDialog {

    public FileOpenDialog(Window window) {
        super(window);
    }

    @Override
    public File show() {
        return builder.build().showOpenDialog(window);
    }
}
