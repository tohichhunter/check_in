/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin.DAO;

import in.pleasecome.tohich_hunter.checkin.entity.Note;
import java.util.List;

/**
 *
 * @author toxa
 */
public interface NoteDAO extends EntityDAO<Note>
{
    @Override
    public void add(Note note);
    @Override
    public void edit(Note note);
    @Override
    public void delete(Note note);
    @Override
    public Note findByID(Long id);
    
    public List<Note> findByUsername(String id, int skip);
    
    public List<Note> findLastNotes(int numberOfNotes);
}
