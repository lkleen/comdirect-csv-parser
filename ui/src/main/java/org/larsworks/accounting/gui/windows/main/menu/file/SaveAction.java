package org.larsworks.accounting.gui.windows.main.menu.file;

import org.larsworks.accounting.gui.configuration.app.ApplicationConfiguration;
import org.larsworks.accounting.gui.configuration.app.ApplicationConfigurationManager;
import org.larsworks.accounting.gui.windows.main.controller.MainWindowController;
import org.larsworks.accounting.gui.windows.main.dialog.FileChooserDialog;
import org.larsworks.accounting.gui.windows.main.dialog.FileSaveDialog;

import javax.inject.Inject;
import java.io.File;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 05.09.13
 *        Time: 20:22
 */
public class SaveAction extends FileChooserAction {

    @Inject
    private MainWindowController controller;

    @Inject
    private ApplicationConfigurationManager configurationManager;

    @Override
    public void execute() {
        File file = showDialog();
    }

    @Override
    protected FileChooserDialog getDialog() {
        return new FileSaveDialog(controller.getMainPane().getScene().getWindow());
    }

    @Override
    protected File getLastDir() {
        return configurationManager.get().getLastSaveLocation();
    }

    @Override
    protected void setLastDir(File file) {
        if(file != null && file.isFile()) {
            ApplicationConfiguration applicationConfiguration = configurationManager.get();
            applicationConfiguration.setLastSaveLocation(file.getParentFile());
            configurationManager.set(applicationConfiguration);
        }
    }
}
