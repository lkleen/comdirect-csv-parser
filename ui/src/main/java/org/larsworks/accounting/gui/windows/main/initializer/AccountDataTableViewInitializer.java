package org.larsworks.accounting.gui.windows.main.initializer;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import lombok.extern.slf4j.Slf4j;
import org.larsworks.accounting.core.controllers.CategoryManager;
import org.larsworks.accounting.core.model.AccountDataEntry;
import org.larsworks.accounting.core.statistics.Category;
import org.larsworks.accounting.gui.initializer.Initializer;
import org.larsworks.accounting.gui.initializer.TableColumnInitializer;

/**
 *
 * Date: 7/23/13
 * Time: 5:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class AccountDataTableViewInitializer extends Initializer<TableView> {

    private static final int CATEGORY_COL_INDEX = 5;

    private final CategoryManager categoryManager;

    class CategoryCell extends TableCell<AccountDataEntry, Category> {
        final ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(categoryManager.getCategories()));

        @Override
        protected void updateItem(Category category, boolean empty) {
            choiceBox.getSelectionModel().select(category);
            setGraphic(choiceBox);
        }
    }

    class CategoryProperty extends ObservableValueBase<Category> {
        final Category category;

        public CategoryProperty(Category category) {
            this.category = category;
        }

        @Override
        public Category getValue() {
            return category;
        }

    }

    public AccountDataTableViewInitializer(TableView tableView, CategoryManager categoryManager) {
        super(tableView);
        this.categoryManager = categoryManager;
    }

    @Override
    public void init() {
        new TableColumnInitializer<AccountDataEntry>(initializable).init(AccountDataEntry.class);

        initializable.getColumns().remove(CATEGORY_COL_INDEX);
        TableColumn<AccountDataEntry, Category> col = new TableColumn<>("Category");
        initializable.getColumns().add(col);

        col.setCellFactory(new Callback<TableColumn<AccountDataEntry, Category>, TableCell<AccountDataEntry, Category>>() {
            @Override
            public TableCell<AccountDataEntry, Category> call(TableColumn<AccountDataEntry, Category> categoryCategoriesTableColumn) {
                TableCell categoryCell = new CategoryCell();
                categoryCell.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<javafx.scene.input.MouseEvent>() {
                    @Override
                    public void handle(javafx.scene.input.MouseEvent mouseEvent) {
                        CategoryCell source = (CategoryCell) mouseEvent.getSource();
                        TableRow row = source.getTableRow();
                        initializable.getSelectionModel().select(row.getIndex());
                        AccountDataEntry entry = (AccountDataEntry) initializable.getSelectionModel().getSelectedItem();
                        Category category = (Category) source.choiceBox.getSelectionModel().getSelectedItem();
                        entry.setCategory(category);
                    }
                });
                return categoryCell;
            }
        });

        col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AccountDataEntry, Category>, ObservableValue<Category>>() {
            @Override
            public ObservableValue<Category> call(TableColumn.CellDataFeatures<AccountDataEntry, Category> accountDataEntryCategoryCellDataFeatures) {
                return new CategoryProperty(accountDataEntryCategoryCellDataFeatures.getValue().getCategory());
            }
        });

    }
}
