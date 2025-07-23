package org.exampleSeleniumFrameworkProjectVWO.bddTestCasesRestfulAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.greaterThan;

public class GetAPIWithBDD_UsingMainMethod {
    public static void main(String[] args) {
        System.out.println("Get API with BDD");
        RestAssured.
                given().baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON).log().all()
                .when().get("/booking")
                .then().log().all().statusCode(200)
                .body("size()", greaterThan(0));

    }
}
