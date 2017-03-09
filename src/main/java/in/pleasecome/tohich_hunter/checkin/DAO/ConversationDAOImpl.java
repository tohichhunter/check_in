/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Conversation;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
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
        Object result=getHibernateTemplate().get(Conversation.class, id);
        if(result!=null)
        {
            return (Conversation)result;
        }
        throw new NullPointerException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Conversation> findByUserID(Long id)
    {
        List<Long> result=(List<Long>)(Object)getHibernateTemplate().find("select conversations from users where id = ?", id);
        if(result!=null)
        {
            List<Conversation> conversations = new LinkedList<>();
            for(Long conversationID: result)
            {
                conversations.add(getHibernateTemplate().get(Conversation.class, conversationID));
            }
            return conversations;
        }
        throw new NullPointerException();
    }
    
    
}
