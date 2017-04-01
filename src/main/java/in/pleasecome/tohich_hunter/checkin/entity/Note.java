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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author toxa
 */
@Entity
@Component
@Table(name = "notes")
public class Note implements Serializable
{

    private static final long serialVersionUID = -1727784337714965533L;    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @Column(name = "photos")
    private Set<String> photos;
    @Transient
    private Set<MultipartFile> files;
    @Column(name = "location")
    private Long location;
    @Column(name = "username")
    private String username;

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

    public String getUser()
    {
        return username;
    }

    public void setUser(String username)
    {
        this.username = username;
    }

    public Set<MultipartFile> getFiles()
    {
        return files;
    }

    public void setFiles(Set<MultipartFile> files)
    {
        this.files = files;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "Note{" + "id=" + id + ", name=" + name + ", photos=" + photos + ", files=" + files + ", location=" + location + ", username=" + username + '}';
    }

}
