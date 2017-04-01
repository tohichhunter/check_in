/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Message;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.FlushMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author toxa
 */
public class MessageDAOImpl extends HibernateDaoSupport implements MessageDAO
{

    @Override
    @Transactional(readOnly = false)
    public void add(Message message)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(message);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Message message)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().update(message);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Message message)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().delete(message);
    }

    @Override
    @Transactional(readOnly = true)
    public Message findByID(Long id)
    {
        Object result=getHibernateTemplate().get(Message.class, id);
        if(result!=null)
        {
            return (Message)result;
        }
        throw new NullPointerException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> findByConversationID(Long id)
    {
         List<Long> result=(List<Long>)(Object)getHibernateTemplate().find("select id from messages where conversation_id = ?", id);
        if(result!=null)
        {
            List<Message> messages = new LinkedList<>();
            for(Long messageID: result)
            {
                messages.add(getHibernateTemplate().get(Message.class, messageID));
            }
            return messages;
        }
        throw new NullPointerException();
    }
    
}
