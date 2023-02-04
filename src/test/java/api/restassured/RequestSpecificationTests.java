package api.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import logger.CustomLogger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class RequestSpecificationTests {

    @BeforeClass
    public void setup() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://5e09b25a-c867-4177-9cae-701b213cc53b.mock.pstmn.io")
                .addHeader("header", "value1")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-mock-match-request-headers", "header")
                .log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8")
                .expectHeader("responseHeader", "resValue1")
                .log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void requestSpecExample() {

        get("/get");
    }

    @Test
    public void queryTest() {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(RestAssured.requestSpecification);
        queryableRequestSpecification.getHeaders()
                .forEach(header -> CustomLogger.logger.info(header.getName() + " : " + header.getValue()));
    }

}
