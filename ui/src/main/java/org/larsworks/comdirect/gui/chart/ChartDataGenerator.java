package org.larsworks.comdirect.gui.chart;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import org.joda.time.format.DateTimeFormat;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.model.AccountDataEntry;

/**
 * Date: 7/24/13
 * Time: 3:05 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class ChartDataGenerator {

    public List<XYChart.Data<String, Float>> generateFrom(AccountData accountData) {
        List<XYChart.Data<String, Float>> list = new ArrayList<XYChart.Data<String, Float>>();
        for(AccountDataEntry entry : accountData.getAccountDataEntries()) {
            String date = entry.getValueDate().toString(DateTimeFormat.shortDate());
            list.add(new XYChart.Data<String, Float>(date, entry.getFluctuation()));
        }
        return list;
    }

    public ObservableList<XYChart.Series<String, Float>> emptySeries() {
        return FXCollections.observableArrayList();
    }
}
