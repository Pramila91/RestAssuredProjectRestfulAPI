package org.exampleSeleniumFrameworkProjectVWO.bddTestCasesRestfulAPI;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBookingDataDrivenPositiveTests extends BaseTest {

    @DataProvider(name = "validBookingIds")
    public Object[][] provideValidBookingIds() {
        // Extract booking IDs as a List
        List<Integer> ids = given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .path("bookingid"); // get all booking ids

        // Get first 5 or fewer if not available
        int size = Math.min(ids.size(), 5);
        Object[][] data = new Object[size][1];
        for (int i = 0; i < size; i++) {
            data[i][0] = ids.get(i);
        }
        return data;
    }

    @Test(dataProvider = "validBookingIds")
    @Epic("Booking API Tests")
    @Feature("GET Booking by ID")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test that valid booking IDs return HTTP 200 and booking details")
    public void validBookingId_shouldReturn200AndDetails(int bookingId) {
        given()
                .when()
                .get("/booking/" + bookingId)
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", notNullValue())
                .body("bookingdates.checkin", notNullValue());
    }
}

