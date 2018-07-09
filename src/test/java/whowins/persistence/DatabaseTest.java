package whowins.persistence;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {

    Database testObj;

    @Before
    public void setup(){
        testObj = new Database();
    }

    @Test
    public void getConnection() {
        testObj.createConnection();
    }
}
