package org.larsworks.comdirect.gui.windows.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.core.controllers.AccountDataMerger;
import org.larsworks.comdirect.core.controllers.CategoryManager;
import org.larsworks.comdirect.core.io.DirReader;
import org.larsworks.comdirect.core.parser.AccountDataParser;
import org.larsworks.comdirect.gui.windows.main.initializer.AccountDataBarChartInitializer;
import org.larsworks.comdirect.gui.windows.main.initializer.AccountDataTableViewInitializer;
import org.larsworks.comdirect.gui.windows.main.menu.file.ImportAction;
import org.larsworks.comdirect.gui.windows.main.menu.file.PreferencesAction;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Date: 7/23/13
 * Time: 3:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class MainWindowController implements Initializable {

    @FXML
    @Getter
    private TableView accountDataTableView;

    @FXML
    @Getter
    private LineChart accountDataLineChart;

    @FXML
    @Getter
    private StackedBarChart accountDataBarChart;

    @FXML
    @Getter
    private AnchorPane mainPane;

    @Inject
    private ImportAction importAction;

    @Inject
    private PreferencesAction preferencesAction;

    @Inject
    private CategoryManager categoryManager;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableView();
        initializeBarChart();
    }

    private void initializeBarChart() {
        new AccountDataBarChartInitializer(accountDataBarChart).init();

    }

    private void initializeTableView() {
        new AccountDataTableViewInitializer(accountDataTableView, categoryManager).init();
    }

    @FXML
    public void importData(ActionEvent event) {
        importAction.execute();
    }

    @FXML
    public void preferences(ActionEvent event) {
        preferencesAction.execute();
    }

}
