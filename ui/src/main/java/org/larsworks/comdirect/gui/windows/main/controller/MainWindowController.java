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
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.gui.windows.main.initializer.AccountDataBarChartInitializer;
import org.larsworks.comdirect.gui.windows.main.initializer.AccountDataTableViewInitializer;
import org.larsworks.comdirect.gui.windows.main.menu.file.ImportAction;
import org.larsworks.comdirect.gui.windows.main.menu.file.PreferencesAction;

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
    private TableView accountDataTableView;

    @FXML
    private LineChart accountDataLineChart;

    @FXML
    private StackedBarChart accountDataBarChart;

    @FXML
    private AnchorPane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableView();
        initializeBarChart();
    }

    private void initializeBarChart() {
        new AccountDataBarChartInitializer(accountDataBarChart).init();

    }

    private void initializeTableView() {
        new AccountDataTableViewInitializer(accountDataTableView).init();
    }

    @FXML
    public void importData(ActionEvent event) {
        Window window = mainPane.getScene().getWindow();
        new ImportAction(window, accountDataTableView, accountDataLineChart, accountDataBarChart).execute();
    }

    @FXML
    public void preferences(ActionEvent event) {
        new PreferencesAction().execute();
    }

}
