package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;

import java.io.IOException;

public class PrivateChatPage {

    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button goBack;


    @FXML
    public void minimize(){
        btnMinimize.setOnMouseClicked(minimize->{
            ((Stage)((Button)minimize.getSource()).getScene().getWindow()).setIconified(true);
        });
    }
    @FXML public void close() {
        btnClose.setOnMouseClicked(close -> {
            System.exit(0);
        });
    }
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
