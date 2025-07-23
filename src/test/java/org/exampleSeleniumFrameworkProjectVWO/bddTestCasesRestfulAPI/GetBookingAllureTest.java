package org.exampleSeleniumFrameworkProjectVWO.bddTestCasesRestfulAPI;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Epic("Booking API Tests")
@Feature("GET Booking by ID")
public class GetBookingAllureTest extends BaseTest {

    @Test(description = "Verify valid booking ID returns booking details")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test validates that a valid booking ID returns 200 OK and expected fields.")
    public void validBookingId_shouldReturnBookingDetails() {
        given()
                .when()
                .get("/booking/25")
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("bookingdates.checkin", notNullValue());
    }
}
