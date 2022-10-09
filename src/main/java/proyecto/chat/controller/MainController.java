package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;
import proyecto.chat.logging.Logging;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DAO.RoomsDAO;
import proyecto.chat.utils.JAXBManager;
import proyecto.chat.utils.socket.Client;
import proyecto.chat.utils.socket.Server;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    /**
     * Atributos de la clase.
     */
    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button btnChatSport;
    @FXML private Button btnChatCook;
    @FXML private Button btnChatVideogames;
    @FXML private Button btnChatMusic;
    @FXML private Button btnHelp;
    @FXML private Button btnRules;

    /**
     * Función que hace que la ventana se minimice en la barra de tareas.
     */
    @FXML public void minimize(){
        btnMinimize.setOnMouseClicked(minimize->{
            ((Stage)((Button)minimize.getSource()).getScene().getWindow()).setIconified(true);
        });
    }

    /**
     * Función que hace que el programa se cierre.
     */
    @FXML public void close(){
        btnClose.setOnMouseClicked(close->{
            System.exit(0);
        });
    }

    /**
     * Función que te lleva al chat que elijas de la aplicación.
     * @throws Exception
     */

    @FXML public void chatPage() throws Exception {
        App.setRoot("chatPage");
    }

    @FXML public void nickPage() throws Exception {
        App.setRoot("nickname");
    }

    /*
    @Override
    @FXML public void chatPage() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chatPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            Logging.warningLogging(e+"");
        }
        App.setRoot("nickname");
        btnChatSport.setOnMouseClicked(go->{
            try {
                App.setRoot(("chatPage"));
                Stage s = new Stage();
                s.setScene();
                ChatController sport = new ChatController();
                sport.setChatName(null);
                sport.setChatName(new Label("Sport Chat"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btnChatCook.setOnMouseClicked(go->{
            try {
                App.setRoot(("chatPage"));
                ChatController cook = new ChatController();
                cook.setChatName(null);
                cook.setChatName(new Label("Cook Chat"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    */
 @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Server serv = new Server();
        RoomsDAO rda = JAXBManager.load("chatsFile.xml");
        if (rda.isEmpty()) {
            rda = new RoomsDAO();
            rda.addRoom(new Room("Sport", 50, null, null));
            rda.addRoom(new Room("Cook", 20, null, null));
            rda.addRoom(new Room("Videogames", 50, null, null));
            rda.addRoom(new Room("Music", 20, null, null));
            Client cli = new Client();
            JAXBManager.save(rda, "chatsFile.xml");
            Logging.infoLogging("Entorno creado");
            //new InfoMessage("Entorno creado","Info").showMessage();
        }
        else{
            Logging.infoLogging("Entorno cargado");
            //new InfoMessage("Entorno cargado","Info").showMessage();
        }

        /*
        Room room = rda.getRoom("Sport");
        UserDAO udao = new UserDAO();
        udao.addUser(new User("usuario_Prueba","0.0.0.0",false,0));
        room.setUsers((List<User>) udao.getAllUsers());
        System.out.println(room);
        JAXBManager.save(rda,"chatsFile.xml");
         */
    }
}
