package org.larsworks.comdirect.gui.windows.preferences.handler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.control.TableView;
import org.larsworks.comdirect.core.model.Categories;
import org.larsworks.comdirect.core.statistics.Category;
import org.larsworks.comdirect.gui.handler.Handler;

import java.util.ArrayList;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 14:07
 */
public class CategoriesTableViewHandler extends Handler<Categories> {

    private final TableView tableView;

    public CategoriesTableViewHandler(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void handle(Categories categories) {
        ObservableList<Category> list = FXCollections.observableList(new ArrayList<>(categories));
        tableView.setItems(list);
    }
}
