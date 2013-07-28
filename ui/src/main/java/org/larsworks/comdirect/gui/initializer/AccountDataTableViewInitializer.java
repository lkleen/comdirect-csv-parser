package org.larsworks.comdirect.gui.initializer;

import javafx.scene.control.TableView;

import org.larsworks.comdirect.core.model.AccountDataEntry;

/**
 * Date: 7/23/13
 * Time: 5:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataTableViewInitializer extends Initializer<TableView> {

    public AccountDataTableViewInitializer(TableView tableView) {
        super(tableView);
    }

    @Override
    public void init() {
        new TableColumnInitializer<AccountDataEntry>(t).init(AccountDataEntry.class);
    }
}
