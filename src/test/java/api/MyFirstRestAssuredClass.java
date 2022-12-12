package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class MyFirstRestAssuredClass {
    public static final String url = "http://demo.guru99.com/V4/sinkministatement.php";

    public static void getResponseBody() {

        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(url).then().log()
                .body();
    }

    public static void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

    public static void getSpecificPartOfResponseBody(){

        ArrayList<String> amounts = given()
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .contentType(ContentType.JSON)
                .header("Content-Type","application/json\r\n").get(url).then().extract().htmlPath().get("result:.statements.AMOUNT") ;
        int sumOfAll=0;
        for(String a:amounts){

            System.out.println("The amount value fetched is "+a);
            sumOfAll=sumOfAll+Integer.valueOf(a);
        }
        System.out.println("The total amount is "+sumOfAll);

    }
    @Test
    public void test(){
        getResponseStatus();
        getSpecificPartOfResponseBody();
    }

}
