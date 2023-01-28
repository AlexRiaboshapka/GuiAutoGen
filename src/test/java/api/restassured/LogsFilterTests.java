package api.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class LogsFilterTests {

    @BeforeClass
    public void setUp() throws FileNotFoundException {
        PrintStream file = new PrintStream(new File("target/LogsFilterTestsLog.txt"));
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("http://postman-echo.com")
                .setBasePath("/get")
                .addFilter(new RequestLoggingFilter(LogDetail.ALL, file))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL, file));
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    // Filter the logs using predefined filters RequestLoggingFilter and ResponseLoggingFilter
    // Save the logs in a file
    @Test
    public void queryParameters() {

        given()
                .when().get()
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
