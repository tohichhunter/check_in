/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

/**
 *
 * @author toxa
 * @param <T>
 */
public interface  EntityDAO<T>
{
    public void add(T t);
    public void edit(T t);
    public void delete(T t);
    T findByID(Long id);
}
