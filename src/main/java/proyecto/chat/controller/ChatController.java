package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyecto.chat.App;

import java.io.IOException;

public class ChatController {

    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button send;
    @FXML private Button goBack;
    @FXML private TableView tvUserTable;
    @FXML private TextField tfWriteMessage;

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

    @FXML public void sendMessage(){
        send.setOnMouseClicked(send->{
            tfWriteMessage.getText();

        });
    }

    @FXML public void privateChatPage() {
        tvUserTable.setOnMouseClicked(privateChatPage->{
            try {
                App.setRoot("privateChatPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML public void goBack() {
        goBack.setOnMouseClicked(goBack->{
            try {
                App.setRoot("mainPage.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
