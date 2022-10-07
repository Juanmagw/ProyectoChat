package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import proyecto.chat.App;
import proyecto.chat.model.DAO.RoomsDAO;
import proyecto.chat.model.DAO.UserDAO;
import proyecto.chat.model.DataObject.Room;
import proyecto.chat.model.DataObject.User;
import proyecto.chat.utils.JAXBManager;

import java.io.IOException;
import java.util.List;

public class NicknameController {

    /**
     * Atributos de la clase.
     */
    @FXML private Button accept;
    @FXML private Button cancel;
    @FXML private TextField nickname;

    /**
     * Función que te introduce a la ventana de chat si el nickname no estaba siendo usado anteriormente y
     * te da error si lo estaba.
     */
    @FXML private void accept(){
        accept.setOnMouseClicked(accept->{
            RoomsDAO rda = JAXBManager.load("chatsFile.xml");
            Room room = rda.getRoom("Sport");
            UserDAO udao = new UserDAO();
            udao.addUser(new User(this.nickname.getText(),"0.0.0.0",false,0));
            room.setUsers((List<User>) udao.getAllUsers());
            System.out.println(room);
            JAXBManager.save(rda,"chatsFile.xml");
            //if exists mensaje exists
            System.exit(0);
        });
    }

    /**
     * Función que hace que la ventana del nickname se cierre.
     */
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

    /**
     * Función que valida que el texto sea un String.
     */
    private void validator(){
        nickname.getText();
    }
}
