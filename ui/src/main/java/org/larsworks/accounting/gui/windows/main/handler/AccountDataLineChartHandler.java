package org.larsworks.accounting.gui.windows.main.handler;

import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Tooltip;
import org.larsworks.accounting.core.model.AccountData;
import org.larsworks.accounting.core.model.AccountDataEntry;
import org.larsworks.accounting.gui.handler.AccountDataHandler;
import org.larsworks.accounting.gui.windows.main.charts.LineChartDataGenerator;

import javax.inject.Inject;

/**
 * Date: 7/23/13
 * Time: 6:08 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataLineChartHandler extends AccountDataHandler<LineChart> {

    @Inject
    private LineChartDataGenerator dataGenerator;

    @Override
    public void handle(AccountData accountData, LineChart lineChart) {
        XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();

        series.getData().addAll(dataGenerator.generateFrom(accountData));
        lineChart.setData(dataGenerator.emptySeries());
        lineChart.getData().add(series);
        for(XYChart.Series<String, Float> s : (ObservableList<XYChart.Series<String, Float>>)lineChart.getData()) {
            for(XYChart.Data<String, Float> d : s.getData()) {
                AccountDataEntry entry = (AccountDataEntry) d.getExtraValue();
                Tooltip.install(d.getNode(), new Tooltip(entry.toString()));
            }
        }
    }

}
