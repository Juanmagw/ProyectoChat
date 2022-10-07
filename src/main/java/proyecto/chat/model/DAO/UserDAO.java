package proyecto.chat.model.DAO;

import proyecto.chat.model.DataObject.User;

import java.util.ArrayList;
import java.util.Collection;

public class UserDAO {

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
