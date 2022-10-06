package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import proyecto.chat.App;

import java.io.IOException;

public class NicknameController {

    @FXML private Button accept;
    @FXML private Button cancel;
    @FXML private TextField nickname;

    @FXML private void accept(){
        accept.setOnMouseClicked(accept->{
            //if exists mensaje exists
            System.exit(0);
        });
    }
    @FXML private void cancel(){
        cancel.setOnMouseClicked(cancel->{
            System.exit(0);
            try {
                App.setRoot("mainPage");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
