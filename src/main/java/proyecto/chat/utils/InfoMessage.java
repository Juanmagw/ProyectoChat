package proyecto.chat.utils;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class InfoMessage extends Message {

	/**
	 * Constructor con parametros
	 * @param message Mensaje a mostrar
	 * @param title Titulo del mensaje a mostrar
	 */
	public InfoMessage(String message, String title) {
		super(message, title);
	}

	/**
	 * Muestra una pantalla de alerta de tipo Information
	 */
	@Override
	public void showMessage() {
		Alert a = new Alert(Alert.AlertType.INFORMATION);
		a.initStyle(StageStyle.TRANSPARENT);
		a.setHeaderText(null);
		a.setTitle(this.title);
		a.setContentText(this.message);
		a.showAndWait();
		
	}

}
