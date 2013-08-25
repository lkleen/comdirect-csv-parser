package org.larsworks.comdirect.gui.windows.main.menu.file;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.larsworks.comdirect.gui.windows.PreferencesWindow;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 12:57
 */
public class PreferencesAction extends MenuItemAction {

    private final PreferencesWindow preferencesWindow = new PreferencesWindow();

    @Override
    public void execute() {
        Stage stage = new Stage();
        stage.setScene(new Scene(preferencesWindow.get()));
        stage.show();
    }
}
