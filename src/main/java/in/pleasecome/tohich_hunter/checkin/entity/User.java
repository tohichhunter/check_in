/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
@Table(name = "users")
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "nativetown_id")
    private Long nativeTown;
    
    @Column(name = "username")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @ElementCollection( targetClass = Long.class )
    @Column(name = "locations")
    private Set<Long> locations;
    
    @ElementCollection( targetClass = Conversation.class )
    @Column(name = "conversations")
    private Set<Conversation> conversations;
    
    @ElementCollection( targetClass = Note.class )
    @Column(name = "notes")
    private List<Note> notes;
    
    @Column(name = "enabled")
    private boolean enabled;

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Long getNativeTown()
    {
        return nativeTown;
    }

    public void setNativeTown(Long nativeTown)
    {
        this.nativeTown = nativeTown;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Set<Long> getLocations()
    {
        return locations;
    }

    public void setLocations(Set<Long> locations)
    {
        this.locations = locations;
    }

    public Set<Conversation> getConversations()
    {
        return conversations;
    }

    public void setConversations(Set<Conversation> conversations)
    {
        this.conversations = conversations;
    }

    public List<Note> getNotes()
    {
        return notes;
    }

    public void setNotes(List<Note> notes)
    {
        this.notes = notes;
    }
    
    public User()
    {
        
    }
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User))
        {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nativeTown=" + nativeTown + ", email=" + email + ", password=" + password + ", enabled=" + enabled + '}';
    }

   

    
}
