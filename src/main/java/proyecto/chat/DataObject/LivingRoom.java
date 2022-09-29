package proyecto.chat.DataObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="room")
public class LivingRoom implements Serializable {

    /**
     *  Atributos de clase
     */
    static final long serialVersionUID = 1L;
    private String nombre;
    private int numMax;
    private List<User> users;

    /**
     *
     * @param nombre Nombre de la sala
     * @param numMax Número maximo de usuarios que se pueden conectar
     * @param users Usuarios conectados
     */
    public LivingRoom(String nombre, int numMax, List<User> users) {
        this.nombre = nombre;
        this.numMax = numMax;
        this.users = users;
    }

    /**
     * Constructor por defecto
     */
    public LivingRoom() {
        this("Ramdon",10,null);
    }

    /**
     * Obtiene el nombre de la sala
     * @return Nombre de la sala
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setea el nombre de la sala
     * @param nombre Nombre de la sala
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número máximo de usuarios que pueden conectarse
     * @return Número máximo de usuarios
     */
    public int getNumMax() {
        return numMax;
    }

    /**
     * Setea el número de máximo de usuarios que se pueden conectar
     * @param numMax
     */
    public void setNumMax(int numMax) {
        this.numMax = numMax;
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
}
