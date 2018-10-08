package whowins.service;

import whowins.model.Fighter;
import whowins.persistence.Database;
import whowins.persistence.DatabaseImpl;

import java.util.List;

/**
 * Created by Freddie on 05/08/2018.
 */
public class FighterService {

    Database db = new DatabaseImpl();

    public List<Fighter> getAllFighters(){
        return db.getAllFighters();
    }
}
