package org.larsworks.comdirect.gui.windows.preferences.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import lombok.extern.slf4j.Slf4j;
import org.larsworks.comdirect.core.controllers.CategoryManager;
import org.larsworks.comdirect.core.model.Categories;
import org.larsworks.comdirect.core.statistics.Category;
import org.larsworks.comdirect.gui.windows.preferences.handler.CategoriesKeyEventHandler;
import org.larsworks.comdirect.gui.windows.preferences.handler.CategoriesTableViewHandler;
import org.larsworks.comdirect.gui.windows.preferences.initializer.CategoriesTableViewInitializer;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 13:45
 */
@Slf4j
public class PreferencesWindowController implements Initializable {

    @FXML
    private TextField preferencesCategoriesName;

    @FXML
    private TableView categoriesTableView;

    @Inject
    private CategoryManager categoryManager;

    @Inject
    private CategoriesTableViewHandler categoriesTableViewHandler;

    @Inject
    private CategoriesKeyEventHandler categoriesKeyEventHandler;

    private Categories categories;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new CategoriesTableViewInitializer(categoriesTableView).init();
        categories = categoryManager.getCategories();
        categoriesTableViewHandler.handle(categories, categoriesTableView);
    }

    @FXML
    void add() {
        Category category = new Category(preferencesCategoriesName.getText());
        categories.add(category);
        categoriesTableViewHandler.handle(categories, categoriesTableView);
        categoryManager.save(categories);
    }

    @FXML
    void remove() {}

    @FXML
    void keyPressed(KeyEvent event) {
        categoriesKeyEventHandler.handle(event, categories);
        categoriesTableViewHandler.handle(categories, categoriesTableView);
        categoryManager.save(categories);
    }

}
