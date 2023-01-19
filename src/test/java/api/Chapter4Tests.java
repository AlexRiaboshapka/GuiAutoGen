package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter4Tests {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeMethod
    public void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://zippopotam.us/").build();
    }

    @BeforeMethod
    public void createResponseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills_withRequestSpec() {
        given()
                .spec(requestSpecification)
                .when()
                .get("us/90210")
                .then()
                .spec(responseSpecification).statusCode(200)
                .assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_extractPlaceNameFromResponseBody_assertEqualToBeverlyHills() {
        String placeName =
                given().
                        when().
                        get("http://zippopotam.us/us/90210").
                        then().
                        extract().
                        path("places[0].'place name'");

        Assert.assertEquals(placeName, "Beverly Hills");
    }
}
