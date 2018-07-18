package whowins.persistence;

import whowins.model.Fighter;

import java.sql.Connection;
import java.util.List;

public interface Database {

    void createConnection();

    Connection getConnection();

    void insertFighter(Fighter fighter);

    void deleteFighter(Fighter fighter);

    Fighter getfighterByName(String name);

    List<Fighter> getFightersWithAge(int age);

    int getFighterCount();
}
