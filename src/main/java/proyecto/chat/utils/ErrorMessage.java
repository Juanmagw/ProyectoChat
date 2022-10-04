package proyecto.chat.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class ErrorMessage extends Message {

	/**
	 * Constructor con parametros
	 * @param message Mensaje a mostrar
	 * @param title Titulo del mensaje
	 */
	public ErrorMessage(String message, String title) {
		super(message,title);
	}

	/**
	 * Muestra una pantalla de alerta de tipo Error
	 */
	@Override
	public void showMessage() {
		Alert a = new Alert(Alert.AlertType.ERROR);
		a.initStyle(StageStyle.TRANSPARENT);
		a.setHeaderText(null);
		a.setTitle(this.title);
		a.setContentText(this.message);
		a.showAndWait();
	}

}
