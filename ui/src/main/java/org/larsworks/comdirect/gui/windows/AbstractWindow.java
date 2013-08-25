package org.larsworks.comdirect.gui.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.larsworks.comdirect.gui.exceptions.WindowLoadException;

import java.io.IOException;
import java.net.URL;

/**
 * @author Lars Kleen
 * @since 0.0.1
 *        Date: 25.08.13
 *        Time: 13:30
 */
public class AbstractWindow {

    private final String filename;

    private Parent parent;

    public AbstractWindow(String filename) {
        this.filename = filename;
    }

    public Parent load() {
        URL url = getClass().getClassLoader().getResource(filename);
        FXMLLoader loader = new FXMLLoader(url);
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
