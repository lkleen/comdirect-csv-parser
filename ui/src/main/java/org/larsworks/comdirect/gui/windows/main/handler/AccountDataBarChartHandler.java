package org.larsworks.comdirect.gui.windows.main.handler;

import javafx.collections.FXCollections;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.statistics.*;
import org.larsworks.comdirect.gui.handler.AccountDataHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 22:58
 */
public class AccountDataBarChartHandler extends AccountDataHandler {

    private final StackedBarChart barChart;

    public AccountDataBarChartHandler(StackedBarChart barChart) {
        this.barChart = barChart;
    }

    @Override
    public void handle(AccountData accountData) {
        clearChart();
        fillChartWith(accountData);
    }

    private void fillChartWith(AccountData accountData) {
        List<XYChart.Series<String, Float>> list = new ArrayList<XYChart.Series<String, Float>>();
        AccountingStatistic statistic = new AccountingStatistic(accountData);
        AccountingStatisticsData data = statistic.generator().generate();
        for(AccountingPeriod period : data.getPeriods()) {
            XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
            series.setName(period.getMonth().getAsText());
            series.getData().add(fluctuationFrom("deposits", period.getDeposits()));
            series.getData().add(fluctuationFrom("withdraws", period.getWithdraws()));
            list.add(series);
        }
        barChart.setData(FXCollections.observableArrayList(list));
    }

    private void clearChart() {
        barChart.setData(FXCollections.emptyObservableList());
    }

    private XYChart.Data<String, Float> fluctuationFrom(String category, Collection<? extends Fluctuation> fluctuations) {
        float sum = 0F;
        for(Fluctuation fluctuation : fluctuations) {
            float value = fluctuation.getValue();
            sum += value < 0 ? -value : value;
        }
        return new XYChart.Data<String, Float>(category, sum);
    }

}
