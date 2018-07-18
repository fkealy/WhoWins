package whowins.rest;

import org.junit.Test;
import whowins.functional.FunctionalTest;

import static io.restassured.RestAssured.given;

/**
 * Created by Freddie on 14/07/2018.
 */
public class FightersRestTest extends FunctionalTest {

    @Test
    public void testGetFighters() {
        given().when()
                .get("/all-fighters")
                .then()
                .statusCode(200);
    }

}
