package proyecto.chat.utils;

public abstract class Message {

    /**
     * Atributo de clase
     */
    protected String message;
    protected String title;

    /**
     * Constructor
     * @param message mensaje a mostrar
     */
    public Message(String message,String title) {
        this.message = message;
        this.title = title;
    }

    /**
     * Constructor por defecto
     */
    public Message() {
        this("Contenido no disponible.","");
    }

    /**
     * Metodo abstrato en el que se mostrará un mensaje
     */
    abstract public void showMessage();
}
