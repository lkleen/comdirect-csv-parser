package org.larsworks.accounting.gui.windows.main.dialog;

import javafx.stage.FileChooserBuilder;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 * Date: 28.08.13
 * Time: 19:20
 */
@Slf4j
public abstract class FileChooserDialog extends Dialog<File> {

    protected final FileChooserBuilder builder;

    public FileChooserDialog(Window window) {
        super(window);
        builder = FileChooserBuilder.create();
        builder.title("choose import file");
    }

    @Override
    public abstract File show();

    public File showWith(File initialDirectory) {
        if(initialDirectory != null && initialDirectory.isDirectory()) {
            builder.initialDirectory(initialDirectory);
        } else {
            log.warn("tried to open dialog with invalid initial directory: " + initialDirectory);
        }
        return show();
    }
}