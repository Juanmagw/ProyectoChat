package proyecto.chat.model.DAO;

import proyecto.chat.DataObject.Room;
import proyecto.chat.DataObject.Rooms;
import proyecto.chat.logging.Logging;

public class RoomsDAO {

    /**
     * Método que añade una sala creada al list de salas
     * @param rooms List de salas
     * @param room Sala a añadir
     * @return True o false si hubo éxito o no
     */
    public boolean addRoom(Rooms rooms, Room room) {
        Logging.infoLogging("Creando sala");
        return rooms.getRooms().add(room);
    }
}
