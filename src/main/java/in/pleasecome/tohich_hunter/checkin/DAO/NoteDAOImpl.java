/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Note;
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
public class NoteDAOImpl extends HibernateDaoSupport implements NoteDAO
{

    @Override
    @Transactional(readOnly = false)
    public void add(Note note)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(note);
    }

    @Override
    @Transactional(readOnly = false)
    public void edit(Note note)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(note);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Note note)
    {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(note);
    }

    @Override
    @Transactional(readOnly = true)
    public Note findByID(Long id)
    {
        Object result = getHibernateTemplate().get(Note.class, id);
        if (result != null)
        {
            return (Note) result;
        }
        throw new NullPointerException();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Note> findByUsername(String id, int skip)
    {
        if (skip < 0)
        {
            throw new IllegalArgumentException();
        }
        Query query = getSessionFactory().getCurrentSession().
                createQuery("FROM in.pleasecome.tohich_hunter.checkin.entity.Note N WHERE N.username = :username");
        query.setParameter("username", id);
        query.setMaxResults(skip + 10);
        if (query.list() != null)
        {
            List<Note> result = null;
            try
            {
                result = new LinkedList<>(query.list().subList(skip, skip + 10));
            } catch (IndexOutOfBoundsException e)
            {
                result = new LinkedList<>(query.list());
            }
            if (result != null)
            {
                return result;
            }
            throw new org.hibernate.QueryParameterException(" " + skip);
        }
        throw new NullPointerException();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Note> findLastNotes(int numberOfNotes)
    {
        Query query = getSessionFactory().getCurrentSession().
                createQuery("FROM in.pleasecome.tohich_hunter.checkin.entity.Note ORDER BY timestamp DSC");
        query.setMaxResults(numberOfNotes);
        List<Note> result = new LinkedList<>(query.list().subList(0, 10));
        return result;
    }
}
