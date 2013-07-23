package org.larsworks.comdirect.gui.initializer;

import java.lang.reflect.Field;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Date: 7/23/13
 * Time: 5:50 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class TableColumnInitializer<T> {

    private final TableView tableView;

    public TableColumnInitializer(TableView tableView) {
        this.tableView = tableView;
    }

    public void init(Class<T> clazz) {
        for(Field field : clazz.getDeclaredFields()) {
            String name = field.getName();
            TableColumn col = new TableColumn(name);
            col.setMinWidth(100);
            col.setCellValueFactory(new PropertyValueFactory<T, String>(name));
            tableView.getColumns().add(col);
        }
    }
}
