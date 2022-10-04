package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import proyecto.chat.App;

import java.io.IOException;

public class MainController {

    @FXML private Button btnMinimizar;
    @FXML private Button btnMaximizar;
    @FXML private Button btnCerrar;
    @FXML private Button btnSportChat;
    @FXML private Button btnCookChat;
    @FXML private Button btnVideogamesChat;
    @FXML private Button btnMusicChat;
    @FXML private Button btnHelp;
    @FXML private Button btnRules;

    @FXML public void minimizar(){
        btnMinimizar.setOnMouseClicked(minimizar->{
            ((Stage)((Button)minimizar.getSource()).getScene().getWindow()).setIconified(true);
        });
    }
    @FXML public void cerrar(){
        btnCerrar.setOnMouseClicked(cerrar->{
            System.exit(0);
        });
    }

    @FXML public void chatPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("chatPage.fxml"));
        Stage stage = (Stage) btnSportChat.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 900, 450));
    }
}
