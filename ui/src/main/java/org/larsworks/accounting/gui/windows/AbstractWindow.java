package org.larsworks.accounting.gui.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.larsworks.accounting.gui.exceptions.WindowLoadException;

import java.io.IOException;
import java.net.URL;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 13:30
 */
public class AbstractWindow<Controller> {

    private final String filename;
    private final Controller controller;

    private Parent parent;

    public AbstractWindow(String filename, Controller controller) {
        this.filename = filename;
        this.controller = controller;
    }

    public Parent load() {
        URL url = getClass().getClassLoader().getResource(filename);
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(controller);
        try {
            return (Parent) loader.load();
        } catch (IOException e) {
            throw new WindowLoadException(e);
        }
    }

    public Parent get() {
        if(parent == null) {
            parent = load();
        }
        return parent;
    }
}
