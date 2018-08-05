package whowins.rest;

import org.junit.Test;
import whowins.functional.FunctionalTest;

import static io.restassured.RestAssured.given;

public class FightersRestTest extends FunctionalTest {

    @Test
    public void testGetFighters() {
        given().when()
                .get("/all-fighters")
                .then()
                .statusCode(200);
    }

}
