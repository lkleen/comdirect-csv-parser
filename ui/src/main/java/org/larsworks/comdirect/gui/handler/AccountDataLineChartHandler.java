package org.larsworks.comdirect.gui.handler;

import javafx.scene.chart.LineChart;

import org.larsworks.comdirect.core.model.AccountData;

/**
 * Date: 7/23/13
 * Time: 6:08 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountDataLineChartHandler extends AccountDataHandler {

    private final LineChart lineChart;

    public AccountDataLineChartHandler(LineChart lineChart) {
        this.lineChart = lineChart;
    }

    @Override
    public void handle(AccountData accountData) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
