package org.larsworks.comdirect.gui.windows.main.initializer;

import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import org.larsworks.comdirect.gui.initializer.Initializer;
import org.larsworks.comdirect.gui.windows.main.controller.MainWindowController;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 27.07.13
 *        Time: 23:04
 */
public class AccountDataBarChartInitializer extends Initializer<MainWindowController> {

    @Override
    public void init() {
        CategoryAxis xAxis = (CategoryAxis) initializable.getAccountDataBarChart().getXAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(new String[]{"deposits", "withdraws"}));
    }
}
