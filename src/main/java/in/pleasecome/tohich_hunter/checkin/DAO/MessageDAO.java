/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Message;
import java.util.List;

/**
 *
 * @author toxa
 */
public interface MessageDAO extends EntityDAO<Message>
{
    @Override 
    public void add(Message message);
    @Override
    public void edit(Message message);
    @Override
    public void delete(Message message);
    @Override
    public Message findByID(Long id);
    
    public List<Message> findByConversationID(Long id);
}
