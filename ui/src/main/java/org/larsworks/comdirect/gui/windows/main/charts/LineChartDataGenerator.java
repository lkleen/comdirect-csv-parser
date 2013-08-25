package org.larsworks.comdirect.gui.windows.main.charts;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Tooltip;
import org.joda.time.format.DateTimeFormat;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.model.AccountDataEntry;
import org.larsworks.comdirect.core.controllers.AccountDataAnalyzer;

/**
 * Date: 7/24/13
 * Time: 3:05 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class LineChartDataGenerator {

    public List<XYChart.Data<String, Float>> generateFrom(AccountData accountData) {
        AccountDataAnalyzer analyzer = new AccountDataAnalyzer(accountData);
        float balance = analyzer.getInitialValue();
        List<XYChart.Data<String, Float>> list = new ArrayList<XYChart.Data<String, Float>>();
        for(AccountDataEntry entry : accountData.getAccountDataEntries()) {
            String date = entry.getValueDate().toString(DateTimeFormat.shortDate());
            balance += entry.getFluctuation();
            XYChart.Data<String, Float> data = new XYChart.Data<String, Float>(date, balance);
            data.setExtraValue(entry);
            Tooltip.install(data.getNode(), new Tooltip("asd"));
            list.add(data);
        }
        return list;
    }

    public ObservableList<XYChart.Series<String, Float>> emptySeries() {
        return FXCollections.observableArrayList();
    }
}
