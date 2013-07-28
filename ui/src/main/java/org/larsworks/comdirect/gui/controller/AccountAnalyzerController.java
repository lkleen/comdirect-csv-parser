package org.larsworks.comdirect.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.gui.initializer.AccountDataBarChartInitializer;
import org.larsworks.comdirect.gui.initializer.AccountDataTableViewInitializer;
import org.larsworks.comdirect.gui.menu.file.ImportAction;

/**
 * Date: 7/23/13
 * Time: 3:46 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
@Slf4j
public class AccountAnalyzerController implements Initializable {

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
        new ImportAction(window, accountDataTableView, accountDataLineChart).execute();
    }

}
