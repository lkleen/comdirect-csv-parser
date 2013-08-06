package org.larsworks.comdirect.gui.handler;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.statistics.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

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
        AccountingStatistic statistic = new AccountingStatistic(accountData);
        AccountingStatisticsData data = statistic.generator().generate();

        for(AccountingPeriod period : data.getPeriods()) {
            XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
            series.setName(period.getMonth().getAsText());
            series.getData().add(fluctuationFrom("deposits", period.getDeposits()));
            series.getData().add(fluctuationFrom("withdraws", period.getWithdraws()));
            barChart.getData().add(series);
        }
    }

    private XYChart.Data<String, Float> fluctuationFrom(String category, Collection<? extends Fluctuation> fluctuations) {
        float sum = 0F;
        for(Fluctuation fluctuation : fluctuations) {
            float value = fluctuation.getValue();
            sum += value < 0 ? -value : value;
        }
        return new XYChart.Data<String, Float>(category, sum);
    }

    private Collection<? extends XYChart.Data<String, Float>> fluctuationsFrom(String category, Collection<? extends Fluctuation> fluctuations) {
        Collection<XYChart.Data<String, Float>> list  = FXCollections.observableArrayList();
        for(Fluctuation fluctuation : fluctuations) {
            float value = fluctuation.getValue();
            value = value < 0 ? -value : value;
            list.add(new XYChart.Data<String, Float>(category, value));
        }
        return list;
    }
}
