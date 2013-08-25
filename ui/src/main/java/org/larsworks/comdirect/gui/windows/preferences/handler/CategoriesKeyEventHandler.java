package org.larsworks.comdirect.gui.windows.preferences.handler;

import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.larsworks.comdirect.core.model.Categories;
import org.larsworks.comdirect.core.statistics.Category;
import org.larsworks.comdirect.gui.handler.Handler;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 19:26
 */
@Slf4j
public class CategoriesKeyEventHandler extends Handler<KeyEvent> {

    private final Categories categories;

    public CategoriesKeyEventHandler(Categories categories) {
        this.categories = categories;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case DELETE:
                TableView tableView = (TableView) event.getSource();
                Category category = (Category) tableView.getSelectionModel().getSelectedItem();
                categories.remove(category);
                break;
        }
    }
}
