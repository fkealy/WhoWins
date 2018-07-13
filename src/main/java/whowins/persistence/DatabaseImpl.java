package whowins.persistence;

import whowins.model.Fighter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class DatabaseImpl implements Database {

    private static final String INSERT_FIGHTER_SQL = "INSERT INTO Fighters(Name,DOB,Height) VALUES(?,?,?)";
    private static final String COUNT_FIGHTERS_SQL = "SELECT Count(*) FROM Fighters";
    private static final String GET_FIGHTER_BY_NAME = "SELECT * from Fighters where Name = ?";

    private static Connection c = null;

    @Override
    public void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/WhoWins.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    @Override
    public Connection getConnection() {
        return c;
    }

    @Override
    public void insertFighter(Fighter fighter) {
        insertFighter(fighter.getName(),fighter.getAge(),fighter.getHeight());
    }

    private void insertFighter(String name, int age, int height) {
        String dob = convertAgeToDOB(age);
        try {
            PreparedStatement ps = this.c.prepareStatement(INSERT_FIGHTER_SQL);
            ps.setString(1, name);
            ps.setString(2, dob);
            ps.setInt(3, height);
            ps.executeUpdate();
            close(ps);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Fighter> getFightersWithAge(int age) {
        return null;
    }

    private String convertAgeToDOB(int age) {
        return LocalDate.now().minusYears(age).toString();
    }

    private void close(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public int getFighterCount() {
        int count;
        try {
            PreparedStatement ps = this.c.prepareStatement(COUNT_FIGHTERS_SQL);
            ResultSet rs = ps.executeQuery();
            count = rs.getInt(1);
            close(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            count = -1;
        }
        return count;
    }

    public Fighter getfighterByName(String name) {
        Fighter fighter;
        try {
            PreparedStatement ps = this.c.prepareStatement(GET_FIGHTER_BY_NAME);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            fighter = buildFighter(rs);
            close(ps);
        } catch (SQLException e) {
            e.printStackTrace();
            fighter = new Fighter();
        }
        return fighter;
    }

    private Fighter buildFighter(ResultSet rs) throws SQLException {
        String name = rs.getString("Name");
        int age = getAgeFromDOB(rs.getString("DOB"));
        int height = rs.getInt("Height");
        return new Fighter(name,age,height);
    }

    private int getAgeFromDOB(String dateofbirth){
        CharSequence dob = dateofbirth.subSequence(0,dateofbirth.length());
        return Period.between(LocalDate.parse(dob),LocalDate.now()).getYears();

    }

}

