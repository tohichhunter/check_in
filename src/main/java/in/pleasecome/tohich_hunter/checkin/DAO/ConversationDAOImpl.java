/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Conversation;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toxa
 */
public class ConversationDAOImpl extends HibernateDaoSupport implements ConversationDAO
{

    @Override
    @Transactional(readOnly = false)
    public void add(Conversation conversation)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(conversation);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Conversation conversation)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().update(conversation);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Conversation conversation)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().delete(conversation);
    }

    @Override
    @Transactional(readOnly = true)
    public Conversation findByID(Long id)
    {
        Object result = getHibernateTemplate().get(Conversation.class, id);
        if (result != null)
        {
            return (Conversation) result;
        }
        throw new NullPointerException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conversation> findByUsername(String username)
    {
        Query query = getSessionFactory().getCurrentSession()
                .createQuery("FROM in.pleasecome.tohich_hunter.checkin.entity.Conversation");
        List<Conversation> list = new LinkedList<>(query.list());
        if (list != null)
        {
            List<Conversation> result = new LinkedList<>();
            for (Conversation l : list)
            {
                if (l.getParticiants().contains(username))
                {
                    result.add(l);
                }
            }
            return result;
        }
        throw new NullPointerException();
    }

    @Override
    public Conversation findByParticiants(String... particiants)
    {
        Query query = getSessionFactory().openSession()
                .createQuery("FROM in.pleasecome.tohich_hunter.checkin.entity.Conversation");
        List<Conversation> list = new LinkedList<>(query.list());
        if (list != null)
        {
            for (Conversation l : list)
            {
                if (l.getParticiants().size() == particiants.length)
                {
                    if (l.getParticiants().containsAll(Arrays.asList(particiants)))
                    {
                        return l;
                    }
                }
            }
            return null;
        }
        throw new NullPointerException();
    }

}
