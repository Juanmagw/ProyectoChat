package proyecto.chat.utils;

import proyecto.chat.DataObject.Room;
import proyecto.chat.DataObject.Rooms;
import proyecto.chat.logging.Logging;
import javax.xml.bind.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JAXBManager {

    /**
     * Almacena en un archivo xml los datos del chat
     * @param rooms List de chats
     * @param file Nombre de archivo
     */
    public static void save(Rooms rooms, String file) {
        JAXBContext context;
        BufferedWriter bfr;
        try {
            bfr = new BufferedWriter(new FileWriter(file));
            context = JAXBContext.newInstance(Rooms.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(rooms, bfr);
            bfr.close();
            Logging.infoLogging("Escritura en archivo xml exitosa.");
        } catch (IOException e) {
            Logging.warningLogging(e+"");
            new ErrorMessage("Error en escritura del archivo.","Error");
        } catch (PropertyException e) {
            Logging.warningLogging(e+"");
            new ErrorMessage("Error en escritura del archivo.","Error");
        } catch (JAXBException e) {
            Logging.warningLogging(e+"");
            new ErrorMessage("Error en escritura del archivo.","Error");
        }
    }

    /**
     * Obtiene de un archivo xml los datos de los chats y usuarios
     * @param file Nombre del archivo a cargar
     * @return List con los chats almacenados
     */
    public static Rooms load(String file) {
        Rooms result = null;
        result = new Rooms();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Room.class);
            Unmarshaller um = context.createUnmarshaller();
            result=(Rooms)um.unmarshal(new File(file));
        } catch (JAXBException e) {
            Logging.warningLogging(e+"");
            new ErrorMessage("Error al cargar el archivo.","Error");
        }
        Logging.infoLogging("Archivo xml cargado.");
        return result;
    }
}
