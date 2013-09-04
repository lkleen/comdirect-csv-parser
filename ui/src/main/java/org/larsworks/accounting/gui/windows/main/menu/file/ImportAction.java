package org.larsworks.accounting.gui.windows.main.menu.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.larsworks.accounting.core.io.CsvFileFilter;
import org.larsworks.accounting.core.io.DirReader;
import org.larsworks.accounting.core.io.TextFile;
import org.larsworks.accounting.core.model.AccountData;
import org.larsworks.accounting.core.controllers.AccountDataMerger;
import org.larsworks.accounting.core.parser.AccountDataParser;
import org.larsworks.accounting.gui.windows.main.controller.MainWindowController;
import org.larsworks.accounting.gui.windows.main.dialog.FileChooserDialog;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataBarChartHandler;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataLineChartHandler;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataTableViewHandler;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Date: 7/23/13
 * Time: 4:43 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class ImportAction extends MenuItemAction {

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

    @Override
    public void execute() {
        List<AccountData> accountDataList = parseFilesFrom(getPath());
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
        if(dir == null) {
            return Collections.emptyList();
        }
        List<TextFile> files = dirReader.readDir(dir.getAbsolutePath(), new CsvFileFilter());
        List<AccountData> accountDatas = new ArrayList<AccountData>(files.size());
        for(TextFile file : files) {
            accountDatas.add(parser.parse(file));
        }
        return accountDatas;
    }

    private File getPath() {
        FileChooserDialog dialog = new FileChooserDialog(controller.getMainPane().getScene().getWindow());
        return dialog.show();
    }
}
