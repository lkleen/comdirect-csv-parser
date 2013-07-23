package org.larsworks.comdirect.gui;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * Date: 7/23/13
 * Time: 3:33 PM
 *
 * @author lkleen
 * @version 0.0.1
 */
public class Loader {

    public Parent load() throws Exception {
        URL url = getClass().getClassLoader().getResource("gui.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        return (Parent) loader.load();

    }

}
