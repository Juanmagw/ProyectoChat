package proyecto.chat.model.DAO;

import javafx.fxml.Initializable;
import proyecto.chat.model.DataObject.User;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Users")
public class UserDAO implements Serializable {

    static final long serialVersionUID = 1L;
    Collection<User> users = new ArrayList<>();

    public boolean addUser(User user){
        return users.add(user);
    }

    public boolean removeUser(User user){
        return users.remove(user);
    }

    public Collection<User> getAllUsers(){
        return users.stream().toList();
    }
}
