/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.entity;

import java.io.Serializable;
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
@Table(name = "towns")
@Component
@Entity
public class Town implements Serializable
{

    private static final long serialVersionUID = 2943897388593076936L;    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longtitude")
    private Float longtitude;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;

    public Town()
    {

    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Float getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Float latitude)
    {
        this.latitude = latitude;
    }

    public Float getLongtitude()
    {
        return longtitude;
    }

    public void setLongtitude(Float longtitude)
    {
        this.longtitude = longtitude;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
        if (!(object instanceof Town))
        {
            return false;
        }
        Town other = (Town) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Town{" + "id=" + id + ", latitude=" + latitude + ", longtitude=" + longtitude + ", name=" + name + ", country=" + country + '}';
    }

}
