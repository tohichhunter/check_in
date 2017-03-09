/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "notes")
public class Note implements Serializable
{

    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @ElementCollection( targetClass = String.class )
    @Column(name = "photos")
    private Set<String> photos;
    @Column(name = "location")
    private Long location;
    @Column(name = "user")
    private Long user;
    
    public Note()
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
        if (!(object instanceof Note))
        {
            return false;
        }
        Note other = (Note) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Set<String> getPhotos()
    {
        return photos;
    }

    public void setPhotos(Set<String> photos)
    {
        this.photos = photos;
    }

    public Long getLocation()
    {
        return location;
    }

    public void setLocation(Long location)
    {
        this.location = location;
    }

    public Long getUser()
    {
        return user;
    }

    public void setUser(Long user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "in.pleasecome.tohich_hunter.checkin.entity.Note[ id=" + id + " ]";
    }
    
}
