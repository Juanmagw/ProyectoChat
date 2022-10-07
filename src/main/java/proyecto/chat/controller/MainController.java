package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import proyecto.chat.App;
import proyecto.chat.logging.Logging;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DAO.RoomsDAO;
import proyecto.chat.utils.JAXBManager;
import proyecto.chat.utils.Utils;

import java.io.IOException;
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
    @FXML public void chatPage() throws IOException {
        /*try {
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
        }*/
        App.setRoot("nickname");
        /*btnChatSport.setOnMouseClicked(go->{
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
        });*/
    }
 @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Room room = new Room();
        RoomsDAO rda = new RoomsDAO();
        rda.addRoom(room);
        JAXBManager.save(rda,"chatsFile.xml");

    }
}
