package org.larsworks.comdirect.gui.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.model.AccountDataEntry;

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
        ObservableList list = FXCollections.observableArrayList(accountData.getAccountDataEntries());
        tableView.setItems(list);
        log.debug(list.toString());
    }

}
