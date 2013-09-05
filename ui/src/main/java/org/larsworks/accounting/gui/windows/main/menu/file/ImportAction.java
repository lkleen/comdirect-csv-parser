package org.larsworks.accounting.gui.windows.main.menu.file;

import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.controllers.AccountDataMerger;
import org.larsworks.accounting.core.io.CsvFileFilter;
import org.larsworks.accounting.core.io.DirReader;
import org.larsworks.accounting.core.io.TextFile;
import org.larsworks.accounting.core.model.AccountData;
import org.larsworks.accounting.core.parser.AccountDataParser;
import org.larsworks.accounting.gui.configuration.app.ApplicationConfiguration;
import org.larsworks.accounting.gui.configuration.app.ApplicationConfigurationManager;
import org.larsworks.accounting.gui.windows.main.controller.MainWindowController;
import org.larsworks.accounting.gui.windows.main.dialog.FileChooserDialog;
import org.larsworks.accounting.gui.windows.main.dialog.FileOpenDialog;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataBarChartHandler;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataLineChartHandler;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataTableViewHandler;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Date: 7/23/13
 * Time: 4:43 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class ImportAction extends FileChooserAction {

    @Inject
    private MainWindowController controller;

    @Inject
    private AccountDataLineChartHandler lineChartHandler;

    @Inject
    private AccountDataTableViewHandler tableViewHandler;

    @Inject
    private AccountDataBarChartHandler barChartHandler;

    @Inject
    @Named("ISO-8859-1")
    private DirReader dirReader;

    @Inject
    private AccountDataParser parser;

    @Inject
    private AccountDataMerger merger;

    @Inject
    private ApplicationConfigurationManager configurationManager;

    @Override
    public void execute() {
        List<AccountData> accountDataList = parseFilesFrom(showDialog());
        AccountData accountData = merge(accountDataList);
        updateTableViewWith(accountData);
        updateLineChartWith(accountData);
        updateBarChartWith(accountData);
    }

    private void updateBarChartWith(AccountData accountData) {
        barChartHandler.handle(accountData, controller.getAccountDataBarChart());
    }

    private void updateLineChartWith(AccountData accountData) {
        lineChartHandler.handle(accountData, controller.getAccountDataLineChart());
    }

    private void updateTableViewWith(AccountData accountData) {
        tableViewHandler.handle(accountData, controller.getAccountDataTableView());
    }

    private AccountData merge(List<AccountData> accountDataList) {
        return merger.merge(accountDataList);
    }

    private List<AccountData> parseFilesFrom(File dir) {
        if (dir == null) {
            return Collections.emptyList();
        }
        List<TextFile> files = dirReader.readDir(dir.getAbsolutePath(), new CsvFileFilter());
        List<AccountData> accountDatas = new ArrayList<AccountData>(files.size());
        for (TextFile file : files) {
            accountDatas.add(parser.parse(file));
        }
        return accountDatas;
    }

    @Override
    protected FileChooserDialog getDialog() {
        return new FileOpenDialog(controller.getMainPane().getScene().getWindow());
    }

    @Override
    protected File getLastDir() {
        ApplicationConfiguration configuration = configurationManager.get();
        return configuration.getLastImportLocation();
    }

    @Override
    protected void setLastDir(File file) {
        if (file != null && file.isFile()) {
            ApplicationConfiguration configuration = configurationManager.get();
            configuration.setLastImportLocation(file.getParentFile());
            configurationManager.set(configuration);
        }
    }
}
