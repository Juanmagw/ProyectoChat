package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;

public class MainController {

    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button btnChat;
    @FXML private Button btnHelp;
    @FXML private Button btnRules;

    @FXML public void minimize(){
        btnMinimize.setOnMouseClicked(minimize->{
            ((Stage)((Button)minimize.getSource()).getScene().getWindow()).setIconified(true);
        });
    }
    @FXML public void close(){
        btnClose.setOnMouseClicked(close->{
            System.exit(0);
        });
    }

    @FXML public void chatPage() throws Exception {
        App.setRoot("chatPage");
    }
}
