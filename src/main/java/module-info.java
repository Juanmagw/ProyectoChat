module proyecto.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.logging;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;


    opens proyecto.chat to javafx.fxml;
    exports proyecto.chat.utils;
    opens proyecto.chat.DataObject to java.xml.bind;
    opens proyecto.chat.utils to java.xml.bind;
    exports proyecto.chat.controller;
    opens proyecto.chat.controller to javafx.fxml;
    exports proyecto.chat;
}