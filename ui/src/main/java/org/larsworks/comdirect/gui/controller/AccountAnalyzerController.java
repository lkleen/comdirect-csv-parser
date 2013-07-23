package org.larsworks.comdirect.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import lombok.extern.slf4j.Slf4j;

import org.larsworks.comdirect.gui.handler.AccountDataTableViewHandler;

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
    private TableView accountDataEntriesTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void importData(ActionEvent event) {
        AccountDataTableViewHandler handler = new AccountDataTableViewHandler(accountDataEntriesTableView);
        handler.handle(null);
    }

}
