package proyecto.chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainPage.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(fxmlLoader.load(), 900, 450);
        stage.setTitle("ProyectoChat");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}