package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class Chapter2Tests {
    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {
        given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void requestUsZipCode90210_checkContentType_expectApplicationJson() {
        given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {
        given()
                .when().log().all()
                .get("http://zippopotam.us/us/90210")
                .then().log().body()
                .contentType(ContentType.JSON);
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
        given()
                .when().log().all()
                .get("http://zippopotam.us/us/90210")
                .then()
                .assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasItem("Beverly Hills"));
    }

    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceNamesInResponseBody_expectOne() {
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places.'place name'", hasSize(1));
    }
}
