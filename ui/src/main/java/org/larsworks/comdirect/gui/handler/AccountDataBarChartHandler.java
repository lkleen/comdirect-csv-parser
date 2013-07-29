package org.larsworks.comdirect.gui.handler;

import javafx.collections.FXCollections;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import org.larsworks.comdirect.core.model.AccountData;
import org.larsworks.comdirect.core.statistics.AccountingPeriod;
import org.larsworks.comdirect.core.statistics.AccountingStatistic;
import org.larsworks.comdirect.core.statistics.AccountingStatisticsData;
import org.larsworks.comdirect.core.statistics.Fluctuation;

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
        AccountingStatistic statistic = new AccountingStatistic(accountData);
        AccountingStatisticsData data = statistic.generator().generate();

        for(AccountingPeriod period : data.getPeriods()) {
            XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
            series.setName(period.getMonth().getAsText());
            series.getData().addAll(fluctuationsFrom("deposits", period.getDeposits()));
            series.getData().addAll(fluctuationsFrom("withdraws", period.getWithdraws()));
            barChart.getData().add(series);
        }
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
