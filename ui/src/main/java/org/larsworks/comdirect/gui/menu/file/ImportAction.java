package org.larsworks.comdirect.gui.menu.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.TableView;

import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Window;
import org.larsworks.comdirect.core.io.CsvFileFilter;
import org.larsworks.comdirect.core.io.DirReader;
import org.larsworks.comdirect.core.io.TextFile;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.operations.AccountDataMerger;
import org.larsworks.comdirect.core.parser.AccountDataParser;
import org.larsworks.comdirect.gui.dialog.DirectoryChooserDialog;
import org.larsworks.comdirect.gui.handler.AccountDataBarChartHandler;
import org.larsworks.comdirect.gui.handler.AccountDataLineChartHandler;
import org.larsworks.comdirect.gui.handler.AccountDataTableViewHandler;

/**
 * Date: 7/23/13
 * Time: 4:43 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class ImportAction extends MenuItemAction {

    final AccountDataLineChartHandler lineChartHandler;
    final AccountDataTableViewHandler tableViewHandler;
    final AccountDataBarChartHandler barChartHandler;
    final DirectoryChooserDialog directoryChooserDialog;

    final DirReader dirReader = new DirReader();
    final AccountDataParser parser = new AccountDataParser();
    final AccountDataMerger merger = new AccountDataMerger();

    public ImportAction(Window window, TableView tableView, LineChart lineChart, StackedBarChart barChart) {
        directoryChooserDialog = new DirectoryChooserDialog(window);
        lineChartHandler = new AccountDataLineChartHandler(lineChart);
        tableViewHandler = new AccountDataTableViewHandler(tableView);
        barChartHandler  = new AccountDataBarChartHandler(barChart);
    }

    @Override
    public void execute() {
        List<AccountData> accountDataList = parseFilesFrom(getPath());
        AccountData accountData = merge(accountDataList);
        updateTableViewWith(accountData);
        updateLineChartWith(accountData);
        updateBarChartWith(accountData);
    }

    private void updateBarChartWith(AccountData accountData) {
        barChartHandler.handle(accountData);
    }

    private void updateLineChartWith(AccountData accountData) {
        lineChartHandler.handle(accountData);
    }

    private void updateTableViewWith(AccountData accountData) {
        tableViewHandler.handle(accountData);
    }

    private AccountData merge(List<AccountData> accountDataList) {
        return merger.merge(accountDataList);
    }

    private List<AccountData> parseFilesFrom(File dir) {
        List<TextFile> files = dirReader.readDir(dir.getAbsolutePath(), new CsvFileFilter());
        List<AccountData> accountDatas = new ArrayList<AccountData>(files.size());
        for(TextFile file : files) {
            accountDatas.add(parser.parse(file));
        }
        return accountDatas;
    }

    private File getPath() {
        return directoryChooserDialog.show();
    }
}
