package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import proyecto.chat.App;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DAO.RoomsDAO;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Room room = new Room();
        RoomsDAO rda = new RoomsDAO();
        rda.addRoom(room);
        JAXBManager.save(rda,"chatsFile.xml");

    }
}
