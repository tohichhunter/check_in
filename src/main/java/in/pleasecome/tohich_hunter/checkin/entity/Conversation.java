/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    private static final long serialVersionUID = 4L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
    @Column(name = "messages")
    private List<Long> messages;
    
    @ElementCollection(targetClass = Long.class, fetch = FetchType.LAZY)
    @Column(name = "particiants")
    private Set particiants;
    
    

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Set<Long> getParticiants()
    {
        return particiants;
    }

    public void setParticiants(Set<Long> particiants)
    {
        this.particiants = particiants;
    }

    public List<Long> getMessages()
    {
        return messages;
    }

    public void setMessages(List<Long> messages)
    {
        this.messages = messages;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    public void addParticiant(Long user)
    {
        particiants.add(user);
    }
    public void addMessage(Long message)
    {
        messages.add(message);
    }
    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversation))
        {
            return false;
        }
        Conversation other = (Conversation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Conversation{" + "id=" + id + ", particiants=" + particiants + '}';
    }

    
    
}
