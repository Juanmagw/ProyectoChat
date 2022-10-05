package proyecto.chat.DataObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="rooms")
public class Rooms implements Serializable {

    /**
     * Atributos de clase
     */
    static final long serialVersionUID = 1L;
    @XmlElement(name="rooms",type=Rooms.class)
    private List<Room> rooms;

    /**
     * Constructor por defecto
     */
    public Rooms() {}

    /**
     * Obtiene un List de chats
     * @return List de chats
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Setea el list de chats
     * @param rooms List de Chats a setear
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}