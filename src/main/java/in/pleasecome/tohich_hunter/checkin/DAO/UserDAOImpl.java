/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.User;
import java.util.List;
import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toxa
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO
{
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = false)
    public void add(User t)
    {
        t.setPassword(passwordEncoder.encode(t.getPassword()));
        getHibernateTemplate().getSessionFactory().getCurrentSession‌​().setFlushMode(Flus‌hMode.AUTO);
        getHibernateTemplate().save(t);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(User t)
    {
       t.setPassword(passwordEncoder.encode(t.getPassword()));
       getHibernateTemplate().getSessionFactory().getCurrentSession‌​().setFlushMode(Flus‌hMode.AUTO);
       getHibernateTemplate().update(t);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(User t)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession‌​().setFlushMode(Flus‌hMode.AUTO);
        getHibernateTemplate().delete(t);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByID(Long id)
    {
        Object result =getHibernateTemplate().get(User.class, id);
        if(result!=null)
        {
            return (User)result;
        }
        throw new RuntimeException(new NullPointerException("There is no user with such id ["+id+"]"));
    }

    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder)
    {
        this.passwordEncoder = passwordEncoder;
    }

   
    
}
