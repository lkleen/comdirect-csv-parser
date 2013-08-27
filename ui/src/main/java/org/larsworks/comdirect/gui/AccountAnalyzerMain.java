package org.larsworks.comdirect.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.larsworks.comdirect.gui.configuration.GuiConfiguration;
import org.larsworks.comdirect.gui.windows.MainWindow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Date: 7/23/13
 * Time: 3:39 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class AccountAnalyzerMain extends Application {

    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(GuiConfiguration.class);
        Scene scene = context.getBean(Scene.class);
        stage.setScene(scene);
        stage.show();
    }
}
