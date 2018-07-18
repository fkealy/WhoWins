package whowins.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import whowins.model.Fighter;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BattleTest {
    Fighter fighter1 = new Fighter();
    Fighter fighter2 = new Fighter("Freddie",25,180);

    Battle testObj;

    @Before
    public void setup(){
        testObj = new Battle(fighter1,fighter2);
    }

    @Test
    public void test2FightersHeightAdv(){
        assertEquals(fighter1.getHeight(),testObj.start().getHeight());
    }

}
