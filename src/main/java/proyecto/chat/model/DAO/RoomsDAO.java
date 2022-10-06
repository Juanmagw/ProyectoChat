package proyecto.chat.model.DAO;

import proyecto.chat.model.DataObject.Room;
import proyecto.chat.logging.Logging;
import proyecto.chat.utils.InfoMessage;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Prueba")
public class RoomsDAO implements Serializable {

    /**
     * Atributos de clase
     */
    static final long serialVersionUID = 1L;
    private Collection<Room> rooms;

    /**
     * Constructor por defecto
     */
    public RoomsDAO() {rooms = new ArrayList<>();}

    /**
     * Método que añade una sala creada al list de salas
     * @param room Sala a añadir
     * @return True o false si hubo éxito o no
     */
    public boolean addRoom(Room room) {
        Logging.infoLogging("Creando sala");
        new InfoMessage("Creando sala", "Info").showMessage();
        return rooms.add(room);
    }
}
