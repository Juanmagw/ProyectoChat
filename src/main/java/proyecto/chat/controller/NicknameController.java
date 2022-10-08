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
import proyecto.chat.utils.ErrorMessage;
import proyecto.chat.utils.Utils;

import java.io.IOException;
import java.util.List;

public class NicknameController {

    /**
     * Atributos de la clase.
     */
    @FXML private Button btnAccept;
    @FXML private Button btnCancel;
    @FXML private TextField tfNickname;

    /**
     * Función que te introduce a la ventana de chat si el nickname no estaba siendo usado anteriormente y
     * te da error si lo estaba.
     */
    @FXML public void accept(){
        btnAccept.setOnMouseClicked(accept->{
            RoomsDAO rda = JAXBManager.load("chatsFile.xml");
            Room room = rda.getRoom("Sport");
            UserDAO udao = new UserDAO();
            udao.addUser(new User(this.tfNickname.getText(),"0.0.0.0",false,0));
            room.setUsers((List<User>) udao.getAllUsers());
            System.out.println(room);
            JAXBManager.save(rda,"chatsFile.xml");
            try {
                if(tfNickname.getText()!=null){
                    App.setRoot("chatPage");
                }else{
                    new ErrorMessage("Debes introducir un nombre de usuario","Error");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Función que hace que la ventana del nickname se cierre.
     */
    @FXML public void cancel(){
        btnCancel.setOnMouseClicked(cancel->{
            try {
                App.setRoot("mainPage");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
