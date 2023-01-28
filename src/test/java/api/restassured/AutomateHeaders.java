package api.restassured;


import io.restassured.http.Header;
import io.restassured.http.Headers;
import logger.CustomLogger;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AutomateHeaders {
    @Test
    public void multipleHeaders() {
        HashMap<String, String> headersMap = new HashMap<>();
        headersMap.put("header", "value1");
        headersMap.put("Content-Type", "application/json");
        headersMap.put("x-mock-match-request-headers", "header");
        Headers headers =
                given().baseUri("https://5e09b25a-c867-4177-9cae-701b213cc53b.mock.pstmn.io")
                        .headers(headersMap)
                        .when().get("/get").then().log().all()
                        .assertThat().statusCode(200).header("responseHeader", "resValue1").extract().headers();
        for (Header header : headers) {
            CustomLogger.logger.info("Header: " + header.getName() + " : " + header.getValue());
        }
    }
}
