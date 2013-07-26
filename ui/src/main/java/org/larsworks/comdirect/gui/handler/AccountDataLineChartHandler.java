package org.larsworks.comdirect.gui.handler;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.gui.chart.ChartDataGenerator;

/**
 * Date: 7/23/13
 * Time: 6:08 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataLineChartHandler extends AccountDataHandler {

    final LineChart lineChart;
    final ChartDataGenerator dataGenerator = new ChartDataGenerator();


    public AccountDataLineChartHandler(LineChart lineChart) {
        this.lineChart = lineChart;
    }

    @Override
    public void handle(AccountData accountData) {
        XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
        series.getData().addAll(dataGenerator.generateFrom(accountData));
        lineChart.setData(dataGenerator.emptySeries());
        lineChart.getData().add(series);
    }

}
