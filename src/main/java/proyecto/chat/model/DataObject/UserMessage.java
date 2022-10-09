package proyecto.chat.model.DataObject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="message")
public class UserMessage implements Serializable {

    /**
     * Atributos de clase
     */
    static final long serialVersionUID = 1L;
    private Date date;
    private String user;
    private String message;

    /**
     * Contructor con parametros
     * @param date Fecha en la que se escribió el mensaje
     * @param user Usuario que escribió el mensaje
     * @param message Mensaje escrito
     */
    public UserMessage(Date date, String user, String message) {
        this.date = date;
        this.user = user;
        this.message = message;
    }

    /**
     * Constructor por defecto
     */
    public UserMessage() {
        this(null,null,"");
    }

    /**
     * Obtiene la fecha en la que se escribio el mensaje
     * @return Fecha del mensaje
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setea la fecha del mensaje
     * @param date Fecha del mensaje
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Obtiene un usuario
     * @return Usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * Setea un usuario
     * @param user Usuario a setear
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Obtiene un mensaje escrito por el usuario
     * @return Mensaje escrito
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setea un mensaje
     * @param message Mensaje escrito
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Da formato a la cadena que se puede mostrar
     * @return Cadena con el mensaje
     */
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return "<" + this.user + ">" + " --> " + df.format(this.date) + " --> " + this.message + "\n";
    }
}
