package whowins.persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import whowins.model.Fighter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {

    private static Database testObj = new DatabaseImpl();
    private static Fighter testFighter = new Fighter("Freddie", 24, 183);

    @BeforeClass
    public static void setup() {
        testObj.createConnection();
    }

    @Test
    public void testConnectionCreated() {
        assertNotNull(testObj.getConnection());
    }

    @Test
    public void testInsertToFighterDB() {
        testObj.deleteFighter(testFighter);
        testObj.insertFighter(testFighter);
        assertEquals(testFighter.getName(), testObj.getfighterByName(testFighter.getName()).getName());
    }

    @Test
    public void testCountFighters() {
        assertEquals(1, testObj.getFighterCount());
    }

    @Test
    public void testGetHeightFromName() {
        testObj.insertFighter(testFighter);
        assertEquals(testFighter.getHeight(), testObj.getfighterByName(testFighter.getName()).getHeight());
    }

    @Test
    public void testGetFighterFromName() {
        assertEquals(testFighter.getName(), testObj.getfighterByName(testFighter.getName()).getName());
    }

    @Test
    public void testInsertFighterAndThenDeleteFighter() {
        testObj.insertFighter(testFighter);
        assertEquals(1,testObj.getFighterCount());
        testObj.deleteFighter(testFighter);
        assertEquals(0,testObj.getFighterCount());
    }
}
