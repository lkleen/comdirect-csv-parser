package org.larsworks.comdirect.gui.initializer;

import java.lang.reflect.Field;
import java.util.Map;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.larsworks.comdirect.core.annotations.processor.ColumnData;
import org.larsworks.comdirect.core.annotations.processor.ColumnDataAnnotationProcessor;
import org.larsworks.comdirect.core.annotations.view.Ignore;

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
        ColumnDataAnnotationProcessor<T> processor = new ColumnDataAnnotationProcessor<T>();
        for(Map.Entry<Field, ColumnData> entry : processor.process(clazz).entrySet()) {
            TableColumn col = new TableColumn(entry.getValue().getName());
            col.setCellValueFactory(new PropertyValueFactory<T, String>(entry.getKey().getName()));
            col.setPrefWidth(entry.getValue().getWidth());
            tableView.getColumns().add(col);
        }

    }
}
