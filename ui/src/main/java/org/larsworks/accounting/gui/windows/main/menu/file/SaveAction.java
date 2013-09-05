package org.larsworks.accounting.gui.windows.main.menu.file;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.model.AccountData;
import org.larsworks.accounting.core.storage.AccountDataCache;
import org.larsworks.accounting.core.storage.AccountDataStorage;
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
@Slf4j
public class SaveAction extends FileChooserAction {

    @Inject
    private MainWindowController controller;

    @Inject
    private ApplicationConfigurationManager configurationManager;

    @Inject
    private AccountDataCache accountDataCache;

    @Inject
    private AccountDataStorage accountDataStorage;

    @Override
    public void execute() {
        File file = showDialog();
        accountDataStorage.setFile(file);
        AccountData accountData = accountDataCache.getAccountData();
        if(file != null && accountData != null) {
            accountDataStorage.store(accountDataCache.getAccountData());
        } else {
            log.warn("could not store " + accountData + " to file " + file);
        }
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
        if (file != null && file.isFile()) {
            ApplicationConfiguration applicationConfiguration = configurationManager.get();
            applicationConfiguration.setLastSaveLocation(file.getParentFile());
            configurationManager.set(applicationConfiguration);
        }
    }
}
