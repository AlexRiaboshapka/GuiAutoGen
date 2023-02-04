package api.restassured;

import api.pojo.Address;
import api.pojo.Geo;
import api.pojo.User;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PojoTaskTests {

/*    Use below freely available public POST API to create a user. This is mocked, so it will not create any user in reality, but it will send a successful response with HTTP Status code 201.

    This is what you need to do as part of this assignment:

            1. Execute the API in the POSTMAN first to make sure it's working as expected

            2. Create a POJO for the request body

            3. Serialize using REST Assured

            4. You can validate the response http status code and the response body. For the body, just validate that the content type is JSON and the presence of the ID field. Value doesn't matter. Just that it should have a non null value.

    URL: https://jsonplaceholder.typicode.com/users

    Method: POST

    Body:

    {
        "name": "Leanne Graham",
            "username": "Bret",
            "email": "Sincere@april.biz",
            "address": {
                "street": "Kulas Light",
                "suite": "Apt. 556",
                "city": "Gwenborough",
                "zipcode": "92998-3874",
                "geo": {
            "lat": "-37.3159",
                    "lng": "81.1496"
        }
    }
    }
    HTTP Status code: 201

    Response body:

    {
        "id": 11
    }


    Questions for this assignment
    How many POJO classes are required to represent this JSON?*/

    @Test
    public void usersPojoTest() {
        Geo geo = new Geo();
        geo.setLat(-37.3159);
        geo.setLng(81.1496);
        Address address = new Address();
        address.setStreet("Kulas Light");
        address.setSuite("Apt. 556");
        address.setCity("Gwenborough");
        address.setZipcode("92998-3874");
        address.setGeo(geo);
        User user = new User();
        user.setName("Leanne Graham");
        user.setUsername("Bret");
        user.setEmail("Sincere@april.biz");
        user.setAddress(address);

        given().body(user).when().post("https://jsonplaceholder.typicode.com/users")
                .then().statusCode(201).contentType("application/json; charset=utf-8")
                .log().all().body("id", notNullValue());

    }
}
