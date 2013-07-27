package org.larsworks.comdirect.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.gui.initializer.AccountDataEntryTableViewInitializer;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTableView();
    }

    private void initializeTableView() {
        new AccountDataEntryTableViewInitializer(accountDataTableView).init();
    }

    @FXML
    public void importData(ActionEvent event) {
        new ImportAction(accountDataTableView, accountDataLineChart).execute();
    }

}
