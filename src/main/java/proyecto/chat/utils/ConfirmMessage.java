package proyecto.chat.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class ConfirmMessage extends Message{

    /**
     * Constructor
     * @param message mensaje de la alerta
     * @param title título de la alerta
     */
    public ConfirmMessage(String message, String title) {
        super(message, title);
    }

    /**
     * Muestra una ventana de confirmación
     */
    @Override
    public void showMessage() {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.initStyle(StageStyle.TRANSPARENT);
        a.setTitle(title);
        a.setContentText(message);
        a.showAndWait();
    }
}
