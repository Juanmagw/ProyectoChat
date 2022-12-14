package proyecto.chat.utils;

import proyecto.chat.logging.Logging;
import proyecto.chat.model.DAO.RoomDAO;

import javax.xml.bind.*;
import java.io.*;

public class JAXBManager {

    /**
     * Almacena en un archivo xml los datos del chat
     * @param rooms List de chats
     * @param file Nombre de archivo
     */
    public static void save(RoomDAO rooms, String file) {
        JAXBContext context;
        BufferedWriter bfr;
        try {
            bfr = new BufferedWriter(new FileWriter(file));
            context = JAXBContext.newInstance(RoomDAO.class);
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
     * @return List con los chats almacenados o null si está vacío
     */
    public static RoomDAO load(String file) {
        RoomDAO result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(RoomDAO.class);
            Unmarshaller um = context.createUnmarshaller();
            File f = new File(file);
            if(!f.exists()){
                f.createNewFile();
            }
            result=new RoomDAO();
            result=(RoomDAO)um.unmarshal(f);
        } catch (JAXBException e) {
            Logging.warningLogging(e+"");
            new ErrorMessage("Error al cargar el archivo.","Error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logging.infoLogging("Archivo xml cargado.");
        return result;
    }
}
