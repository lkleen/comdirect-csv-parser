package org.larsworks.comdirect.gui.windows.main.handler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.gui.handler.AccountDataHandler;

/**
 * Date: 7/23/13
 * Time: 4:55 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class AccountDataTableViewHandler extends AccountDataHandler<TableView> {

    @Override
    public void handle(AccountData accountData, TableView tableView) {
        ObservableList list = FXCollections.observableArrayList(accountData.getAccountDataEntries());
        tableView.setItems(list);
    }

}
