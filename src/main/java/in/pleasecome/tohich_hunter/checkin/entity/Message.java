/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

/**
 *
 * @author toxa
 */
@Entity
@Component
@Table(name = "messages")
public class Message implements Serializable
{

    private static final long serialVersionUID = 3467824274293913629L;    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "conversation_name")
    private String conversationName;
    @Column(name = "sender")
    private String sender;
    @Column(name = "text")
    private String text;
    @Column(name = "addtime")
    private Timestamp addtime;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getConversationName()
    {
        return conversationName;
    }

    public void setConversationName(String conversationName)
    {
        this.conversationName = conversationName;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Timestamp getAddtime()
    {
        return addtime;
    }

    public void setAddtime(Timestamp addtime)
    {
        this.addtime = addtime;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {        
        if (!(object instanceof Message))
        {
            return false;
        }
        Message other = (Message) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString()
    {
        return "Message{" + "id=" + id + ", conversationId=" + conversationName + ", sender=" + sender + ", time=" + addtime + '}';
    }

}
