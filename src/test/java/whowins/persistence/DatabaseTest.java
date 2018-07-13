package whowins.persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import whowins.model.Fighter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    private static Database testObj = new DatabaseImpl();
    private static Fighter testFighter = new Fighter("Freddie",24,183);

    @BeforeClass
    public static void setup(){
        testObj.createConnection();
    }

    @Test
    public void testConnectionCreated() {
        assertNotNull(testObj.getConnection());
    }

    @Test
    public void testInsertToFighterDB(){
        testObj.insertFighter(testFighter);
        assertEquals(testFighter.getName(),testObj.getfighterByName(testFighter.getName()).getName());
    }

    @Test
    public void testCountFighters(){
        assertEquals( 1,testObj.getFighterCount());
    }

    @Test
    public void testGetHeightFromName(){
        assertEquals(testFighter.getHeight(),testObj.getfighterByName("Freddie").getHeight());
    }

    @Test
    public void testGetFighterFromName(){
       assertEquals(testFighter.getName() , testObj.getfighterByName("Freddie").getName());
    }

    //TODO:TEST REMOVAL OF FIGHTER BY NAME FROM DB
}
