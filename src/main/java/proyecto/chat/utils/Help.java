package proyecto.chat.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class Help extends Message{

    /**
     * Constructor
     * @param message mensaje de la alerta
     * @param title título de la alerta
     */
    public Help(String message, String title) {
        super(message, title);
    }

    /**
     * Muestra una ventana de información
     */
    @Override
    public void showMessage() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.initStyle(StageStyle.TRANSPARENT);
        a.setTitle(title);
        a.setContentText(message);
        a.showAndWait();
    }
}
