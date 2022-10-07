package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;
import proyecto.chat.model.DAO.UserDAO;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DAO.RoomsDAO;
import proyecto.chat.model.DataObject.User;
import proyecto.chat.utils.InfoMessage;
import proyecto.chat.utils.JAXBManager;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    /**
     * Atributos de la clase.
     */
    @FXML private Button btnMinimize;
    @FXML private Button btnMaximize;
    @FXML private Button btnClose;
    @FXML private Button btnChat;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RoomsDAO rda = JAXBManager.load("chatsFile.xml");
        if (rda.isEmpty()) {
            rda = new RoomsDAO();
            rda.addRoom(new Room("Sport", 50, null, null));
            rda.addRoom(new Room("Cook", 20, null, null));
            rda.addRoom(new Room("Videogames", 50, null, null));
            rda.addRoom(new Room("Music", 20, null, null));
            JAXBManager.save(rda, "chatsFile.xml");
            new InfoMessage("Entorno creado","Info").showMessage();
        }
        else{
            new InfoMessage("Entorno cargado","Info").showMessage();
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
