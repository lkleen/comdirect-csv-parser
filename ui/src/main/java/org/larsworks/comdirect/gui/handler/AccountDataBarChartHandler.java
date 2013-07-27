package org.larsworks.comdirect.gui.handler;

import javafx.scene.chart.BarChart;
import org.larsworks.comdirect.core.model.AccountData;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 22:58
 */
public class AccountDataBarChartHandler extends AccountDataHandler {

    private final BarChart barChart;

    public AccountDataBarChartHandler(BarChart barChart) {
        this.barChart = barChart;
    }

    @Override
    public void handle(AccountData accountData) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
