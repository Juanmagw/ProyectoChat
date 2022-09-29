module proyecto.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    opens proyecto.chat to javafx.fxml;
    exports proyecto.chat;
}