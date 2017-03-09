/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.pleasecome.tohich_hunter.checkin;

import in.pleasecome.tohich_hunter.checkin.DAO.TownDAO;
import in.pleasecome.tohich_hunter.checkin.entity.Town;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author toxa
 */
@Component
public class TaskerDB implements Runnable
{

    private Town town;
    private TownDAO townDAO;

    public void setTown(Town town)
    {
        this.town = town;
    }

    public void setTownDAO(TownDAO townDAO)
    {
        this.townDAO = townDAO;
    }

    public TaskerDB()
    {

    }

    public TaskerDB(Town town, TownDAO townDAO)
    {
        this.town = town;
        this.townDAO = townDAO;
    }

    @Override
    public void run()
    {
        try
        {
            File list = new File("/home/toxa/Downloads/newworld.txt");
            List<String> city = Files.readAllLines(list.toPath(), StandardCharsets.UTF_8);
            for (String s : city)
            {
                String[] lines = s.split(",");
                town.setCountry(lines[0]);
                town.setName(lines[1]);
                town.setLatitude(Float.valueOf(lines[2]));
                town.setLongtitude(Float.valueOf(lines[3]));
                townDAO.add(town);
            }
        } catch (IOException ex)
        {
            Logger.getLogger(TaskerDB.class.getName()).log(Level.SEVERE, "Some error has occured", ex);
        }
    }

}
