package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;
import java.io.IOException;

public class PrivateChatPage {

    /**
     * Atributos de la clase.
     */
    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button goBack;

    /**
     * Función que hace que la ventana se minimice en la barra de tareas.
     */
    @FXML
    public void minimize(){
        btnMinimize.setOnMouseClicked(minimize->{
            ((Stage)((Button)minimize.getSource()).getScene().getWindow()).setIconified(true);
        });
    }

    /**
     * Función que hace que el programa se cierre.
     */
    @FXML public void close() {
        btnClose.setOnMouseClicked(close -> {
            System.exit(0);
        });
    }

    /**
     * Función que te lleva a la pestaña anterior.
     */
    @FXML public void goBack() {
        goBack.setOnMouseClicked(goBack->{
            try {
                App.setRoot("chatPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
