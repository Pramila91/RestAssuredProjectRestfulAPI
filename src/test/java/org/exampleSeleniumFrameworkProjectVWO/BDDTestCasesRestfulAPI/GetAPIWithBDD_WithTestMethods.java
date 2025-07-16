package org.exampleSeleniumFrameworkProjectVWO.BDDTestCasesRestfulAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAPIWithBDD_WithTestMethods extends BaseTest {

           @Test
            public void getBookingById_shouldReturnJoshAllenBooking() {
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get("/booking/25")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("firstname", equalTo("Josh"))
                        .body("lastname", equalTo("Allen"))
                        .body("totalprice", equalTo(111))
                        .body("depositpaid", equalTo(true))
                        .body("bookingdates.checkin", equalTo("2018-01-01"))
                        .body("bookingdates.checkout", equalTo("2019-01-01"))
                        .body("additionalneeds", equalTo("midnight snack"));
            }


}
