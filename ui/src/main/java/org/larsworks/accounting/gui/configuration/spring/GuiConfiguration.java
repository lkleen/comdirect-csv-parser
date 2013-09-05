package org.larsworks.accounting.gui.configuration.spring;

import javafx.scene.Scene;
import org.larsworks.accounting.core.configuration.CoreConfiguration;
import org.larsworks.accounting.core.io.XmlIO;
import org.larsworks.accounting.gui.storage.ApplicationConfigurationStorage;
import org.larsworks.accounting.gui.configuration.app.ApplicationConfigurationManager;
import org.larsworks.accounting.gui.windows.MainWindow;
import org.larsworks.accounting.gui.windows.PreferencesWindow;
import org.larsworks.accounting.gui.windows.main.charts.LineChartDataGenerator;
import org.larsworks.accounting.gui.windows.main.controller.MainWindowController;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataBarChartHandler;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataLineChartHandler;
import org.larsworks.accounting.gui.windows.main.handler.AccountDataTableViewHandler;
import org.larsworks.accounting.gui.windows.main.menu.file.ImportAction;
import org.larsworks.accounting.gui.windows.main.menu.file.PreferencesAction;
import org.larsworks.accounting.gui.windows.main.menu.file.SaveAction;
import org.larsworks.accounting.gui.windows.preferences.controller.PreferencesWindowController;
import org.larsworks.accounting.gui.windows.preferences.handler.CategoriesKeyEventHandler;
import org.larsworks.accounting.gui.windows.preferences.handler.CategoriesTableViewHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Named;
import java.io.File;

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
    public SaveAction saveAction() {
        return new SaveAction();
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

    @Bean
    @Named("applicationConfigurationXmlIO")
    public XmlIO<ApplicationConfigurationStorage> applicationConfigurationXmlIO() {
        return new XmlIO<>(ApplicationConfigurationStorage.class);
    }

    @Bean
    public ApplicationConfigurationStorage applicationConfigurationIO() {
        ApplicationConfigurationStorage storage = new ApplicationConfigurationStorage();
        storage.setFile(new File("application.configuration.xml"));
        return storage;
    }

    @Bean
    public ApplicationConfigurationManager applicationConfigurationManager() {
        return new ApplicationConfigurationManager();
    }

}

