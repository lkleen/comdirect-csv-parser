package org.larsworks.comdirect.gui.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.larsworks.comdirect.csv.model.AccountData;
import org.larsworks.comdirect.csv.model.AccountDataEntry;

/**
 * Date: 7/23/13
 * Time: 4:55 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class AccountDataTableViewHandler extends AccountDataHandler {

    private final TableView tableView;

    public AccountDataTableViewHandler(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(AccountData accountData) {

        ObservableList list = FXCollections.observableArrayList(testData());

        TableColumn col = new TableColumn("blabla");
        col.setMinWidth(100);
        col.setCellValueFactory(new PropertyValueFactory<AccountDataEntry, String>("process"));
        tableView.getColumns().addAll(col);

        tableView.setItems(list);
        log.info(list.toString());
    }

    private List<AccountDataEntry> testData() {
        List<AccountDataEntry> list = new ArrayList<AccountDataEntry>();
        for(int i = 0; i < 10; i++) {
            list.add(randomAccountDataEntry());
        }
        return list;
    }

    private AccountDataEntry randomAccountDataEntry() {
        Random random = new Random();
        return new AccountDataEntry(
                new DateTime(random.nextLong()),
                new DateTime(random.nextLong()),
                "process",
                "text",
                random.nextFloat());
    }
}
