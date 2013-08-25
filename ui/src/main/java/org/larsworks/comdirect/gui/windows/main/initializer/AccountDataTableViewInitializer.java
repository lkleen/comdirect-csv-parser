package org.larsworks.comdirect.gui.windows.main.initializer;

import javafx.scene.control.TableView;

import org.larsworks.comdirect.core.model.AccountDataEntry;
import org.larsworks.comdirect.gui.initializer.Initializer;
import org.larsworks.comdirect.gui.initializer.TableColumnInitializer;

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
        new TableColumnInitializer<AccountDataEntry>(initializable).init(AccountDataEntry.class);
    }
}
