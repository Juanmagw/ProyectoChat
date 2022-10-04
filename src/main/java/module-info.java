module proyecto.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.logging;


    opens proyecto.chat to javafx.fxml;
    exports proyecto.chat;
    exports proyecto.chat.utils;
    opens proyecto.chat.utils to javafx.fxml;
}