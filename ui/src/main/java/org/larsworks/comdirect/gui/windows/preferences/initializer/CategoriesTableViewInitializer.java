package org.larsworks.comdirect.gui.windows.preferences.initializer;

import javafx.scene.control.TableView;
import org.larsworks.comdirect.core.statistics.Category;
import org.larsworks.comdirect.gui.initializer.Initializer;
import org.larsworks.comdirect.gui.initializer.TableColumnInitializer;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 16:34
 */
public class CategoriesTableViewInitializer extends Initializer<TableView> {

    public CategoriesTableViewInitializer(TableView initializable) {
        super(initializable);
    }

    @Override
    public void init() {
        new TableColumnInitializer<Category>(initializable).init(Category.class);
    }
}
