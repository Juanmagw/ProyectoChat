package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import proyecto.chat.App;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    /**
     * Atributos de la clase.
     */
    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button btnSend;
    @FXML private Button btnGoBack;
    @FXML private TableView tvUserTable;
    @FXML private TextField tfWriteMessage;
    @FXML private TextArea taMessages;
    @FXML private Label lblNombreSala;
    @FXML private Label chatName;

    public void setChatName(Label chatName) {
        this.chatName = chatName;
    }

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
     * Función que, al pulsar el botón btnSend envía el mensaje del textField al textArea.
     */
    @FXML public void sendMessage(){
        btnSend.setOnMouseClicked(send -> {
            tfWriteMessage.getText();
            if(tfWriteMessage.getText()!=null){
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                taMessages.setText(dateFormat.format(new Date()) + " <Usuario> " + tfWriteMessage.getText() + "\n");
                taMessages.setWrapText(true);
                tfWriteMessage.setText(null);
            }
        });
    }

    /**
     * Función que ordena el contenido del textArea.
     */
    public void taOrder(){
        taMessages.getText().lines();
    }

    /**
     * Función que te lleva al chat privado de la aplicación.
     */
    @FXML public void privateChatPage() {
        tvUserTable.setOnMouseClicked(privateChatPage->{
            try {
                App.setRoot("privateChatPage");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Función que te lleva a la pestaña anterior.
     */
    @FXML public void goBack() {
        btnGoBack.setOnMouseClicked(goBack->{
            try {
                App.setRoot("mainPage");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
