package org.exampleSeleniumFrameworkProjectVWO.BDDTestCasesRestfulAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAPIWithBDD_UsingMainMethod {
    public static void main(String[] args) {
        System.out.println("Get API with BDD");
        RestAssured.
                given().baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .when().get("/booking/25")
                .then().log().all().statusCode(200);
                //.body("size()", greaterThan(0));

    }
}
