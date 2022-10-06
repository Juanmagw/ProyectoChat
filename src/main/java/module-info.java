module proyecto.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires javafx.base;
    requires javafx.graphics;
    requires java.desktop;
    requires java.logging;


    opens proyecto.chat to javafx.fxml;
    exports proyecto.chat.utils;
    opens proyecto.chat.model.DataObject;
    opens proyecto.chat.model.DAO to java.xml.bind;
    opens proyecto.chat.utils to java.xml.bind;
    exports proyecto.chat.controller;
    opens proyecto.chat.controller to javafx.fxml;
    exports proyecto.chat;
}