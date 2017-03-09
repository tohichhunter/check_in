/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Town;
import java.util.List;

/**
 *
 * @author toxa
 */
public interface TownDAO extends EntityDAO<Town>
{
    @Override
    public void add(Town town);
    @Override
    public void edit(Town town);
    @Override
    public void delete(Town town);
    @Override
    public Town findByID(Long id);
    
    public List<Town> findAll();
}
