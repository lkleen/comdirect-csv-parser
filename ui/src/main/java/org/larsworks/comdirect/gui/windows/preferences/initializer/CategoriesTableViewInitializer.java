package org.larsworks.comdirect.gui.windows.preferences.initializer;

import javafx.scene.control.TableView;
import org.larsworks.comdirect.core.statistics.Category;
import org.larsworks.comdirect.gui.initializer.Initializer;
import org.larsworks.comdirect.gui.initializer.TableColumnInitializer;

import javax.inject.Inject;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 16:34
 */
public class CategoriesTableViewInitializer extends Initializer<TableView> {

    @Inject
    private TableColumnInitializer<Category> tableColumnInitializer;


    @Override
    public void init() {
        tableColumnInitializer.init(initializable, Category.class);
    }
}
