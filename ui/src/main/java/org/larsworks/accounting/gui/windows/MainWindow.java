package org.larsworks.accounting.gui.windows;

import org.larsworks.accounting.gui.windows.main.controller.MainWindowController;

/**
 * Date: 7/23/13
 * Time: 3:33 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class MainWindow extends AbstractWindow<MainWindowController> {

    public MainWindow(MainWindowController controller) {
        super("gui.fxml", controller);
    }
}
