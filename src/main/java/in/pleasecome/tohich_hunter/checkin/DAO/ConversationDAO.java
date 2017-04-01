/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Conversation;
import java.util.List;

/**
 *
 * @author toxa
 */
public interface ConversationDAO extends EntityDAO<Conversation>
{
    @Override
    public void add(Conversation conversation);
    @Override
    public void edit(Conversation conversation);
    @Override
    public void delete(Conversation conversation);
    @Override
    public Conversation findByID(Long id);
    
    public List<Conversation> findByUsername(String username);
    
    public Conversation findByParticiants(String... particiants);
}
