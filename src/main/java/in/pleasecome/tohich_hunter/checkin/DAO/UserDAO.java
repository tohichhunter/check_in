/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.User;
import java.util.List;

/**
 *
 * @author toxa
 */
public interface UserDAO extends EntityDAO<User>
{
    @Override
    public void add(User user);
     @Override
    public void edit(User user);
     @Override
    public void delete(User user);
    @Override
    public User findByID(Long id);
    
    List<User> findAll();
}
