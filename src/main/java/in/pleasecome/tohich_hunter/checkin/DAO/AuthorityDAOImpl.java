/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Authority;
import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toxa
 */
public class AuthorityDAOImpl extends HibernateDaoSupport implements AuthorityDAO
{

    @Override
    @Transactional(readOnly = false)
    public void add(Authority authority)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession‌​().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(authority);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Authority authority)
    {
       getHibernateTemplate().getSessionFactory().getCurrentSession‌​().setFlushMode(Flus‌hMode.AUTO);
       getHibernateTemplate().update(authority);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Authority authority)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession‌​().setFlushMode(Flus‌hMode.AUTO);
        getHibernateTemplate().delete(authority);
    }

    @Override
    @Transactional(readOnly = true)
    public Authority findByID(Long id)
    {
       return getHibernateTemplate().get(Authority.class, id);
    }
    
}
