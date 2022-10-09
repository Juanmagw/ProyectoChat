package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import proyecto.chat.App;
import proyecto.chat.model.DAO.MessageDAO;
import proyecto.chat.model.DAO.RoomDAO;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DataObject.UserMessage;
import proyecto.chat.utils.JAXBManager;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
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
    private RoomDAO rd;
    private UserMessage usm;
    private MessageDAO md;
    private Room room;
    private String nickname;

    public void setNickname(String nickname) {
        this.nickname=nickname;
    }

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
                Date date = new Date();
                usm = new UserMessage(date,"usuario",tfWriteMessage.getText());
                md.addMessage(usm);
                room.setMessages((List<UserMessage>) md.getMessages());
                JAXBManager.save(rd,"chatsFile.xml");
                String result=null;
                for(UserMessage m : room.getMessages()){
                    result=taMessages.getText() + m.toString();
                }
                taMessages.setText(result);
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
        rd = JAXBManager.load("chatsFile.xml");
        md = new MessageDAO();
        room=rd.getRoom("Sport");
    }
}
