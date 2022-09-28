module proyecto.chat {
    requires javafx.controls;
    requires javafx.fxml;


    opens proyecto.chat to javafx.fxml;
    exports proyecto.chat;
}