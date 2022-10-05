package proyecto.chat.controller;

import proyecto.chat.DataObject.Room;
import proyecto.chat.DataObject.Rooms;
import proyecto.chat.logging.Logging;
import proyecto.chat.model.DAO.RoomsDAO;
import proyecto.chat.utils.JAXBManager;

public class SystemController {

    final private int NUM_MAX_CHATS = 4;
    private String chatsFile="chatsFile.xml";
    private Rooms rooms;

    public void loadSystem(){
        Logging.infoLogging("Generando entorno");
        rooms = new Rooms();
        rooms = JAXBManager.load(this.chatsFile);
        if(rooms==null) {
            new RoomsDAO().addRoom(this.rooms,new Room("Sport",20,null,null));
            new RoomsDAO().addRoom(this.rooms,new Room("Cook",10,null,null));
            new RoomsDAO().addRoom(this.rooms,new Room("Videogames",50,null,null));
            new RoomsDAO().addRoom(this.rooms,new Room("Music",20,null,null));
            JAXBManager.save(rooms,chatsFile);
        }
    }
}

