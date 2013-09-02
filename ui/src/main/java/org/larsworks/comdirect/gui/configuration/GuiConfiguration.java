package org.larsworks.comdirect.gui.configuration;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.larsworks.comdirect.core.configuration.CoreConfiguration;
import org.larsworks.comdirect.gui.windows.MainWindow;
import org.larsworks.comdirect.gui.windows.PreferencesWindow;
import org.larsworks.comdirect.gui.windows.main.charts.LineChartDataGenerator;
import org.larsworks.comdirect.gui.windows.main.controller.MainWindowController;
import org.larsworks.comdirect.gui.windows.main.handler.AccountDataBarChartHandler;
import org.larsworks.comdirect.gui.windows.main.handler.AccountDataLineChartHandler;
import org.larsworks.comdirect.gui.windows.main.handler.AccountDataTableViewHandler;
import org.larsworks.comdirect.gui.windows.main.menu.file.ImportAction;
import org.larsworks.comdirect.gui.windows.main.menu.file.PreferencesAction;
import org.larsworks.comdirect.gui.windows.preferences.controller.PreferencesWindowController;
import org.larsworks.comdirect.gui.windows.preferences.handler.CategoriesKeyEventHandler;
import org.larsworks.comdirect.gui.windows.preferences.handler.CategoriesTableViewHandler;
import org.larsworks.comdirect.gui.windows.preferences.initializer.CategoriesTableViewInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Lars Kleen
 * @since 0.1.0
 *        Date: 27.08.13
 *        Time: 20:52
 */
@Configuration
public class GuiConfiguration extends CoreConfiguration {

    @Bean
    public Scene scene() {
        return new Scene(mainWindow().get());
    }

    @Bean
    public MainWindow mainWindow() {
        return new MainWindow(mainWindowController());
    }

    @Bean
    public PreferencesWindow preferencesWindow() {
        return new PreferencesWindow(preferencesWindowController());
    }

    @Bean
    public MainWindowController mainWindowController() {
        return new MainWindowController();
    }

    @Bean
    public PreferencesWindowController preferencesWindowController() {
        return new PreferencesWindowController();
    }

    @Bean
    public LineChartDataGenerator lineChartDataGenerator() {
        return new LineChartDataGenerator();
    }

    @Bean
    public ImportAction importAction() {
        return new ImportAction();
    }

    @Bean
    public PreferencesAction preferencesAction() {
        return new PreferencesAction();
    }

    @Bean
    public AccountDataLineChartHandler accountDataLineChartHandler() {
        return new AccountDataLineChartHandler();
    }

    @Bean
    public AccountDataTableViewHandler accountDataTableViewHandler() {
        return new AccountDataTableViewHandler();
    }

    @Bean
    public AccountDataBarChartHandler accountDataBarChartHandler() {
        return new AccountDataBarChartHandler();
    }

    @Bean
    public CategoriesTableViewHandler categoriesTableViewHandler() {
        return new CategoriesTableViewHandler();
    }

    @Bean
    public CategoriesKeyEventHandler categoriesKeyEventHandler() {
        return new CategoriesKeyEventHandler();
    }
}
