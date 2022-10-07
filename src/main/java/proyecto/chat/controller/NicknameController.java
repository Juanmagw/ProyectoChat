package proyecto.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import proyecto.chat.App;
import proyecto.chat.utils.ErrorMessage;
import proyecto.chat.utils.Utils;

import java.io.IOException;

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
    @FXML private void accept(){
        btnAccept.setOnMouseClicked(accept->{
            try {
                if(tfNickname.getText()!=null){
                    App.setRoot("chatPage");
                }else{
                    new ErrorMessage("Debes introducir un nombre de usuario","Error");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //if exists mensaje exists
        });
    }

    /**
     * Función que hace que la ventana del nickname se cierre.
     */
    @FXML private void cancel(){
        btnCancel.setOnMouseClicked(cancel->{
            try {
                App.setRoot("mainPage");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
