package org.exampleSeleniumFrameworkProjectVWO.BDDTestCasesRestfulAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.lessThan;

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

            // 1.Positive Test – Valid ID
    @Test
    public void validBookingId_shouldReturnBookingDetails() {
        given()
                .when()
                .get("/booking/25")
                .then()
                .log().all()
                .statusCode(200)
                .body("firstname", notNullValue())
                .body("bookingdates.checkin", notNullValue());
    }

    // 2. Negative Test – Non-existing ID
    @Test
    public void nonExistingBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/9999")
                .then()
                .log().all()
                .statusCode(404);
    }

    // 3.  Negative Test – Invalid ID (Alphanumeric)

    @Test
    public void invalidAlphanumericBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/abc123")
                .then()
                .log().all()
                .statusCode(404);
    }

    // 4.  Negative Test – Invalid ID (Special Characters)
    @Test
    public void invalidSpecialCharactersBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/!@#$%^&*()")
                .then()
                .log().all()
                .statusCode(404);
    }

    // 5.  Negative Test – Invalid ID (Whitespace)
    @Test
    public void invalidWhitespaceBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/   ")
                .then()
                .log().all()
                .statusCode(404);
    }

    // 6.  Negative Test – Invalid ID (Empty String)
    @Test
    public void emptyBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 7.  Negative Test – Invalid ID (Zero)
    @Test
    public void zeroBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/0")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 8.  Negative Test – Invalid ID (Negative Number)
    @Test
    public void negativeBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/-1")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 9.  Negative Test – Invalid ID (Decimal Number)
    @Test
    public void decimalBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/1.5")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 10. Negative Test – Invalid ID (Large Number)
    @Test
    public void largeBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/1000000000")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 11. Negative Test – Invalid ID (Boolean)
    @Test
    public void booleanBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/true")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 12. Negative Test – Invalid ID (Null)
    @Test
    public void nullBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/null")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 13. Negative Test – Invalid ID (Array)
    @Test
    public void arrayBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/[1,2,3]")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 14. Negative Test – Invalid ID (Object)
    @Test
    public void objectBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/{\"key\": \"value\"}")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 15. Negative Test – Invalid ID (XML)
    @Test
    public void xmlBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/<xml><key>value</key></xml>")
                .then()
                .log().all()
                .statusCode(404);
    }

    // 16. Negative Test – Invalid ID (HTML)
    @Test
    public void htmlBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/<html><body><h1>value</h1></body></html>")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 17. Negative Test – Invalid ID (SQL)
    @Test
    public void sqlBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/SELECT * FROM users")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 18. Negative Test – Invalid ID (JSON)
    @Test
    public void jsonBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/{\"key\": \"value\"}")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 19. Negative Test – Invalid ID (CSV)
    @Test
    public void csvBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/1,2,3")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 20. Negative Test – Invalid ID (YAML)
    @Test
    public void yamlBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/key: value")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 21. Negative Test – Invalid ID (Text)
    @Test
    public void textBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/This is a text")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 22. Negative Test – Invalid ID (Binary)
    @Test
    public void binaryBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/0101010101010101")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 23. Negative Test – Invalid ID (Base64)
    @Test
    public void base64BookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/dGhpcyBpcyBhIHRleHQ=")
                .then()
                .log().all()
                .statusCode(404);
    }
    // 24. Negative Test – Invalid ID (URL)
    @Test
    public void urlBookingId_shouldReturn404() {
        given()
                .when()
                .get("/booking/https://www.example.com")
                .then()
                .log().all()
                .statusCode(404);
    }


    //25. Performance testing
    @Test
    public void getBookingPerformance_shouldRespondWithinOneSecond() {
        given()
                .when()
                .get("/booking/25")
                .then()
                .log().status()
                .statusCode(200)
                .time(lessThan(1000L)); // Response in < 1 second
    }

    //26.Security Test – SQL Injection Attempt
    @Test
    public void sqlInjectionAttempt_shouldReturn404() {
        given()
                .when()
                .get("/booking/1%20OR%201=1")
                .then()
                .log().all()
                .statusCode(404);
    }
    //27.Security Test – XSS Attempt
    @Test
    public void xssAttempt_shouldReturn404() {
        given()
                .when()
                .get("/booking/<script>alert('XSS')</script>")
                .then()
                .log().all()
                .statusCode(404);
    }
    //28.Security Test – CSRF Attempt
    @Test
    public void csrfAttempt_shouldReturn404() {
        given()
                .when()
                .get("/booking/1; DROP TABLE users")
                .then()
                .log().all()
                .statusCode(404);
    }
    //29.Security Test – Clickjacking Attempt
    @Test
    public void clickjackingAttempt_shouldReturn404() {
        given()
                .when()
                .get("/booking/1; document.cookie='XSS'")
                .then()
                .log().all()
                .statusCode(404);
    }
    //30.Security Test – Insecure Direct Object Reference
    @Test
    public void insecureDirectObjectReference_shouldReturn404() {
        given()
                .when()
                .get("/booking/../../etc/passwd")
                .then()
                .log().all()
                .statusCode(404);
    }

    //31. Boundary Test – ID = 0

   // @Test
//    public void zeroBookingId_shouldReturn404() {
//        given()
//                .when()
//                .get("/booking/0")
//                .then()
//                .log().all()
//                .statusCode(404);
//    }









}
