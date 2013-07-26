package org.larsworks.comdirect.gui.menu.file;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.LineChart;
import javafx.scene.control.TableView;

import org.larsworks.comdirect.core.io.CsvFileFilter;
import org.larsworks.comdirect.core.io.DirReader;
import org.larsworks.comdirect.core.io.TextFile;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.operations.AccountDataMerger;
import org.larsworks.comdirect.core.parser.AccountDataParser;
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

    final DirReader dirReader = new DirReader();
    final AccountDataParser parser = new AccountDataParser();
    final AccountDataMerger merger = new AccountDataMerger();

    public ImportAction(TableView tableView, LineChart lineChart) {
        lineChartHandler = new AccountDataLineChartHandler(lineChart);
        tableViewHandler = new AccountDataTableViewHandler(tableView);
    }

    @Override
    public void execute() {
        String path = getPath();
        List<AccountData> accountDataList = parseFilesFrom(path);
        AccountData accountData = merge(accountDataList);
        updateTableViewWith(accountData);
        updateLineChartWith(accountData);
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

    private List<AccountData> parseFilesFrom(String path) {
        List<TextFile> files = dirReader.readDir(path, new CsvFileFilter());
        List<AccountData> accountDatas = new ArrayList<AccountData>(files.size());
        for(TextFile file : files) {
            accountDatas.add(parser.parse(file));
        }
        return accountDatas;
    }

    private String getPath() {
        return "C:/Users/lars/workspace/comdirect-csv-parser/core/src/test/resources";
    }
}
