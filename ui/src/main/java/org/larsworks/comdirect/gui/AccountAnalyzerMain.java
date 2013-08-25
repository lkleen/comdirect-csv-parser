package org.larsworks.comdirect.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.larsworks.comdirect.gui.windows.MainWindow;

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
        Scene scene = new Scene(new MainWindow().get());
        stage.setScene(scene);
        stage.show();
    }
}
