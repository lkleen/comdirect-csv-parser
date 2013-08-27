package org.larsworks.comdirect.gui.windows;

import org.larsworks.comdirect.gui.windows.preferences.controller.PreferencesWindowController;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 13:30
 */
public class PreferencesWindow extends AbstractWindow<PreferencesWindowController> {
    public PreferencesWindow(PreferencesWindowController controller) {
        super("preferences.fxml", controller);
    }
}
