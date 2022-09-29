package proyecto.chat.DataObject;

import javafx.fxml.FXML;

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
    private boolean baneado;
    private int numFaltas;

    /**
     *  Constructor parametrizado
     * @param alias Nickname del usuario
     * @param ip Dirección IP del usuario
     * @param baneado Usuario baneado
     * @param numFaltas Numero de faltas del usuario
     */
    public User(String alias, String ip, boolean baneado, int numFaltas) {
        this.alias = alias;
        this.ip = ip;
        this.baneado = baneado;
        this.numFaltas = numFaltas;
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
    public boolean isBaneado() {
        return baneado;
    }

    /**
     * Setea si el usuario es o no baneado
     * @param baneado True o false
     */
    public void setBaneado(boolean baneado) {
        this.baneado = baneado;
    }

    /**
     * Obtiene el número de faltas del usuario
     * @return NUmero de faltas
     */
    public int getNumFaltas() {
        return numFaltas;
    }

    /**
     * Setea el número de faltas del usuario
     * @param numFaltas Número de faltas
     */
    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }
}
