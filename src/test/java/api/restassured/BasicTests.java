package api.restassured;

import api.restassured.files.Helpers;
import api.restassured.files.Payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicTests {


    public static void main(String[] args) {
        String placeId;
        // given() all input details like headers, cookies, body, query parameters
        // when() Submit the API, HTTP method
        //then() Validate the response
        //Add place -> Update place with new address -> Get place to validate if new address is present in response
        //Add place
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given()
                .log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.addPlace()).when()
                .post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();


        placeId = Helpers.rawToJson(response).getString("place_id");
        //Add place -> Update place with new address -> Get place to validate if new address is present in response


        //  Update place with new address
        String newAddress = "70 Summer walk, USA";
        given()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" + "\"place_id\":\"" + placeId + "\",\n" + "\"address\":\"" + newAddress + "\",\n" + "\"key\":\"qaclick123\"\n" + "}")
                .when().put("/maps/api/place/update/json")
                .then().log().all()
                .assertThat()
                .statusCode(200).body("msg", equalTo("Address successfully updated"))
                .header("Server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();

        // Get place to validate if new address is present in response
        given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200)
                .body("address", equalTo(newAddress))
                .header("Server", "Apache/2.4.41 (Ubuntu)");
    }
}
