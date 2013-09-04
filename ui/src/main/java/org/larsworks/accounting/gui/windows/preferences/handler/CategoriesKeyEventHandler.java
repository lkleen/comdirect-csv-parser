package org.larsworks.accounting.gui.windows.preferences.handler;

import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.model.Categories;
import org.larsworks.accounting.core.statistics.Category;
import org.larsworks.accounting.gui.handler.Handler;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 19:26
 */
@Slf4j
public class CategoriesKeyEventHandler extends Handler<KeyEvent, Categories> {

    @Override
    public void handle(KeyEvent event, Categories categories) {
        switch (event.getCode()) {
            case DELETE:
                TableView tableView = (TableView) event.getSource();
                Category category = (Category) tableView.getSelectionModel().getSelectedItem();
                categories.remove(category);
                break;
        }
    }
}
