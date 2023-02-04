package api.restassured;

import io.restassured.config.EncoderConfig;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.config.RestAssuredConfig.config;


public class QueryParametersTests {

    @Test
    public void queryParameters() {
        given().baseUri("http://postman-echo.com")
                .queryParam("foo2", "bar2")
                .when().get("/get")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void multiPartFormData() {
        given().baseUri("http://postman-echo.com")
                .multiPart("foo1", "bar1")
                .log().all()
                .when().post("/post")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void multiPartFormDataFileUpload() {
        given().baseUri("http://postman-echo.com")
                .multiPart("file", new File("src/test/resources/restpayload/FileUpload.txt"))
                .multiPart("attributes", "{'name':'fileUpload.txt'}", "application/json")
                .log().all()
                .when().post("/post")
                .then().log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void formUrlEncoded() {
        given().baseUri("http://postman-echo.com")
                .log().all()
                .config(config()
                        .encoderConfig(EncoderConfig.encoderConfig()
                                .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .contentType("application/x-www-form-urlencoded")
                .when().post("/post")
                .then().log().all()
                .assertThat().statusCode(200);
        //.body(matchesJsonSchemaInClasspath("restpayload/EchoGetSchema.json"));

    }


}
