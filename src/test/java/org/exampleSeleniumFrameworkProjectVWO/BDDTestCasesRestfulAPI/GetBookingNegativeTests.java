package org.exampleSeleniumFrameworkProjectVWO.BDDTestCasesRestfulAPI;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetBookingNegativeTests extends BaseTest {

    @DataProvider(name = "invalidBookingIds")
    public Object[][] provideInvalidBookingIds() {
        return new Object[][] {
                {"999999"},                  // non-existing numeric ID
                {"abc123"},                  // alphanumeric
                {"@#$%"},                    // special characters
                {"<script>alert(1)</script>"}, // XSS script injection
                {"1 OR 1=1"},                // SQL injection
                {" "},                       // blank space
                {"0"},                       // boundary case
                {"999999999"},              // extremely high ID
        };
    }

    @Test(dataProvider = "invalidBookingIds")
    public void invalidBookingId_shouldReturn404(String invalidId) {
        given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/booking/" + invalidId)
                .then()
                .log().all()
                .statusCode(404);
    }
}
