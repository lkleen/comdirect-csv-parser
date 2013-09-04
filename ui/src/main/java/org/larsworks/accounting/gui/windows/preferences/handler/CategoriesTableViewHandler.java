package org.larsworks.accounting.gui.windows.preferences.handler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.larsworks.accounting.core.model.Categories;
import org.larsworks.accounting.core.statistics.Category;
import org.larsworks.accounting.gui.handler.Handler;

import java.util.ArrayList;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 14:07
 */
public class CategoriesTableViewHandler extends Handler<Categories, TableView> {

    @Override
    public void handle(Categories categories, TableView tableView) {
        ObservableList<Category> list = FXCollections.observableList(new ArrayList<>(categories));
        tableView.setItems(list);
    }
}
