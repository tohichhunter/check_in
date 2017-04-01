/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author toxa
 */
@Entity
@Component
@Table(name = "conversations")
public class Conversation implements Serializable
{

    private static final long serialVersionUID = 4577926355113407737L;    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversation_id;

    @Column(name = "conversation_name")
    private String conversationName;

    @JoinColumn(name = "messages.conversation_name")
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Message.class)
    private List<Message> messages = new LinkedList<>();

    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    @Column(name = "particiants")
    private Set<String> particiants;

    public Long getId()
    {
        return conversation_id;
    }

    public void setId(Long id)
    {
        this.conversation_id = id;
    }

    public Set<String> getParticiants()
    {
        return particiants;
    }

    public void setParticiants(Set<String> particiants)
    {
        this.particiants = particiants;
    }

    public List<Message> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Message> messages)
    {
        this.messages = messages;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (conversation_id != null ? conversation_id.hashCode() : 0);
        return hash;
    }

    public void addParticiant(String user)
    {
        particiants.add(user);
    }

    public void addMessage(Message message)
    {
        messages.add(message);
    }

    public String getConversationName()
    {
        return conversationName;
    }

    public void setConversationName(String conversationName)
    {
        this.conversationName = conversationName;
    }

    @Override
    public boolean equals(Object object)
    {        
        if (!(object instanceof Conversation))
        {
            return false;
        }
        Conversation other = (Conversation) object;
        if ((this.conversation_id == null && other.conversation_id != null) || (this.conversation_id != null && !this.conversation_id.equals(other.conversation_id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Conversation{" + "conversation_id=" + conversation_id + ", conversationName=" + conversationName + ", particiants=" + particiants + '}';
    }

    

}
