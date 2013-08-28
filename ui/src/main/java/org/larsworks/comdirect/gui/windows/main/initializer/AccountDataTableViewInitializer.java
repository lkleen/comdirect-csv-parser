package org.larsworks.comdirect.gui.windows.main.initializer;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.scene.control.*;

import javafx.util.Callback;
import org.larsworks.comdirect.core.controllers.CategoryManager;
import org.larsworks.comdirect.core.model.AccountDataEntry;
import org.larsworks.comdirect.core.model.Categories;
import org.larsworks.comdirect.core.statistics.Category;
import org.larsworks.comdirect.gui.initializer.Initializer;
import org.larsworks.comdirect.gui.initializer.TableColumnInitializer;

import javax.inject.Inject;

/**
 * Date: 7/23/13
 * Time: 5:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataTableViewInitializer extends Initializer<TableView> {

    private final CategoryManager categoryManager;

    class CategoryCell extends TableCell<Category, Categories> {
        final ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(categoryManager.getCategories()));

        @Override
        protected void updateItem(Categories category, boolean empty) {
            choiceBox.getSelectionModel().select(category);
            setGraphic(choiceBox);
        }
    }

    class CategoriesProperty extends ObservableValueBase<Categories> {
        final Categories categories;

        public CategoriesProperty(Categories categories) {
            this.categories = categories;
        }

        @Override
        public Categories getValue() {
            return categories;
        }

    }

    public AccountDataTableViewInitializer(TableView tableView, CategoryManager categoryManager) {
        super(tableView);
        this.categoryManager = categoryManager;
    }

    @Override
    public void init() {
        new TableColumnInitializer<AccountDataEntry>(initializable).init(AccountDataEntry.class);

        TableColumn<Category, Categories> col = new TableColumn<>("SUPERDUPER");
        initializable.getColumns().add(col);

        //ChoiceBoxTableCell<Category, Categories> cbtc =

        col.setCellFactory(new Callback<TableColumn<Category, Categories>, TableCell<Category, Categories>>() {
            @Override
            public TableCell<Category, Categories> call(TableColumn<Category, Categories> categoryCategoriesTableColumn) {
                return new CategoryCell();
            }
        });

        col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Category, Categories>, ObservableValue<Categories>>() {
            @Override
            public ObservableValue<Categories> call(TableColumn.CellDataFeatures<Category, Categories> categoryCategoriesCellDataFeatures) {
                return new CategoriesProperty(categoryManager.getCategories());
            }
        });

    }
}
