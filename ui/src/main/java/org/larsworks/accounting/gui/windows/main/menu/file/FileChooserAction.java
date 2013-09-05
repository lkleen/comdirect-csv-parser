package org.larsworks.accounting.gui.windows.main.menu.file;

import org.larsworks.accounting.gui.configuration.app.ApplicationConfiguration;
import org.larsworks.accounting.gui.configuration.app.ApplicationConfigurationManager;
import org.larsworks.accounting.gui.windows.main.dialog.FileChooserDialog;
import org.larsworks.accounting.gui.windows.main.dialog.FileOpenDialog;

import javax.inject.Inject;
import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 20:30
 */
public abstract class FileChooserAction extends MenuItemAction {

    @Inject
    private ApplicationConfigurationManager configurationManager;

    protected File showDialog() {
        FileChooserDialog dialog = getDialog();
        File file = dialog.showWith(getLastDir());
        if (file != null && file.isFile()) {
            setLastDir(file.getParentFile());
        }
        return file;
    }

    protected abstract FileChooserDialog getDialog();

    protected abstract File getLastDir();

    protected abstract void setLastDir(File lastDir);
}
