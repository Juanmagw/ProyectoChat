package proyecto.chat.model.DAO;

import proyecto.chat.model.DataObject.UserMessage;
import proyecto.chat.utils.Message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Messages")
public class MessageDAO implements Serializable {

    static final long serialVersionUID = 1L;

    private Collection<UserMessage> messages;

    public MessageDAO() { this.messages=new ArrayList<>();}

    public boolean addMessage(UserMessage message) {
        return messages.add(message);
    }

    public Collection<UserMessage> getMessages() {
        return messages;
    }
}
