package proyecto.chat.model.DataObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="room")
public class Room implements Serializable {

    /**
     *  Atributos de clase
     */
    static final long serialVersionUID = 1L;
    private String name;
    private int numUsersMax;
    private List<User> users;
    private List<UserMessage> messages;

    /**
     *
     * @param name Nombre de la sala
     * @param numUsersMax Número maximo de usuarios que se pueden conectar
     * @param users Usuarios conectados
     * @param messages Mensajes de texto que escriben los usuarios
     */
    public Room(String name, int numUsersMax, List<User> users, List<UserMessage> messages) {
        this.name = name;
        this.numUsersMax = numUsersMax;
        this.users = users;
        this.messages = messages;
    }

    /**
     * Constructor por defecto
     */
    public Room() {
        this("Ramdon",10,null, null);
    }

    /**
     * Obtiene el nombre de la sala
     * @return Nombre de la sala
     */
    public String getName() {
        return name;
    }

    /**
     * Setea el nombre de la sala
     * @param name Nombre de la sala
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el número máximo de usuarios que pueden conectarse
     * @return Número máximo de usuarios
     */
    public int getNumUsersMax() {
        return numUsersMax;
    }

    /**
     * Setea el número de máximo de usuarios que se pueden conectar
     * @param numUsersMax
     */
    public void setNumUsersMax(int numUsersMax) {
        this.numUsersMax = numUsersMax;
    }

    /**
     * List quel almacena usuarios conectados
     * @return List con usuarios o null si no existe ninguno
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Setea usuarios conectados
     * @param users List de usuarios
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Obtiene los mensajes escritos en el chat
     * @return List de mensajes
     */
    public List<UserMessage> getMessages() {
        return messages;
    }

    /**
     * Setea los mensajes escritos en un chat
     * @param messages List de mensajes a setear
     */
    public void setMessages(List<UserMessage> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Nombre Chat:" + this.name;
    }
}
