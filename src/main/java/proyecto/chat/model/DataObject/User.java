package proyecto.chat.model.DataObject;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
public class User implements Serializable {

    /**
     *  Atributos de clase
     */
    static final long serialVersionUID = 1L;
    private String alias;
    private String ip;
    private boolean banned;
    private int numOffence;

    /**
     *  Constructor parametrizado
     * @param alias Nickname del usuario
     * @param ip Dirección IP del usuario
     * @param banned Usuario baneado
     * @param numOffence Numero de faltas del usuario
     */
    public User(String alias, String ip, boolean banned, int numOffence) {
        this.alias = alias;
        this.ip = ip;
        this.banned = banned;
        this.numOffence = numOffence;
    }

    /**
     * Constructor por defecto
     */
    public User() {
        this("Anónimo","",false,0);
    }

    /**
     * Obtiene el alias de un usuario
     * @return Alias del usuario
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Setea el alias de un usuario
     * @param alias Alias a setear
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Obtiene la dirección IP del usuario
     * @return IP del usuario
     */
    public String getIp() {
        return ip;
    }

    /**
     * Setea la IP del usuario
     * @param ip IP a setear
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Determina si el usuario está baneado o no
     * @return True baneado, false no baneado
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Setea si el usuario es o no baneado
     * @param banned True o false
     */
    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    /**
     * Obtiene el número de faltas del usuario
     * @return NUmero de faltas
     */
    public int getNumOffence() {
        return numOffence;
    }

    /**
     * Setea el número de faltas del usuario
     * @param numOffence Número de faltas
     */
    public void setNumOffence(int numOffence) {
        this.numOffence = numOffence;
    }

    /**
     * Compara un usuario con otro por su atributo alias.
     * Devuelve true o false en case de que sean iguales o no.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result=false;
        if (obj != null) {
            if (this == obj) {
                result = true;
            } else {
                if(obj instanceof User){
                    if (this.alias!=null && this.alias.equals(((User)obj).alias)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
