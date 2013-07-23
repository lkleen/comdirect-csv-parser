package org.larsworks.comdirect.gui.initializer;

import javafx.scene.control.TableView;

import org.larsworks.comdirect.csv.model.AccountDataEntry;

/**
 * Date: 7/23/13
 * Time: 5:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataEntryTableViewInitializer extends Initializer<TableView> {

    public AccountDataEntryTableViewInitializer(TableView tableView) {
        super(tableView);
    }

    @Override
    public void init() {
        new TableColumnInitializer<AccountDataEntry>(t).init(AccountDataEntry.class);
    }
}
