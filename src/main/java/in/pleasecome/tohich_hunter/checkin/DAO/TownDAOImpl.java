/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Town;
import java.util.List;
import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toxa
 */
public class TownDAOImpl extends HibernateDaoSupport implements TownDAO
{

    @Override
    @Transactional(readOnly = false)
    public synchronized void add(Town town)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(town);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Town town)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().update(town);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Town town)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().delete(town);
    }

    @Override
    @Transactional(readOnly = true)
    public Town findByID(Long id)
    {
        Object result=getHibernateTemplate().get(Town.class, id);
        if(result!=null)
        {
            return (Town)result;
        }
        throw new NullPointerException();
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Town> findAll()
    {
        Object result=getHibernateTemplate().find("from in.pleasecome.tohich_hunter.checkin.entity.Town");
        if(result!=null)
        {
            return (List<Town>)result;
        }
        throw new NullPointerException();
    }

      
}
