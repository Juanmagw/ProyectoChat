package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;
import proyecto.chat.logging.Logging;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DAO.RoomDAO;
import proyecto.chat.utils.JAXBManager;
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
            Logging.infoLogging("Aplicación finalizada.");
            System.exit(0);
        });
    }

    @FXML public void nickPage() throws Exception {
        App.setRoot("nickname");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RoomDAO rda = JAXBManager.load("chatsFile.xml");
        if (rda.isEmpty()) {
            rda = new RoomDAO();
            rda.addRoom(new Room("Sport", 50, null, null));
            rda.addRoom(new Room("Cook", 20, null, null));
            rda.addRoom(new Room("Videogames", 50, null, null));
            rda.addRoom(new Room("Music", 20, null, null));
            JAXBManager.save(rda, "chatsFile.xml");
            Logging.infoLogging("Entorno creado");
        }
        else{
            Logging.infoLogging("Entorno cargado");
        }
    }
}
