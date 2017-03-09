/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Authority;

/**
 *
 * @author toxa
 */
public interface AuthorityDAO extends EntityDAO<Authority>
{
    @Override 
    public void add(Authority authority);
    @Override
    public void edit(Authority authority);
    @Override
    public void delete(Authority authority);
    @Override
    public Authority findByID(Long id);
}
