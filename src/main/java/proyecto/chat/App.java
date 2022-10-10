package proyecto.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import proyecto.chat.utils.socket.Server;

import java.io.IOException;

/**
 * Aplicacion de JavaFX en la que se inician las ventanas de diseño grafico.
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) { launch(); }

    /**
     * Crea la escena principal.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainPage"), 900, 450);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Enlaza una escena con otra.
     * @param fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Crea el enlace entre una clase y un archivo .fxml.
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}