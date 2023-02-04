package api.restassured;

import api.pojo.SimplePojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimplePojoTests {
    @BeforeClass
    public void setup() throws IOException {
        Path path = Path.of("src/test/resources/credentials-key.json");

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://api.getpostman.com")
                .addHeader("x-api-key", Files.readString(path))
                .log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8").log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void simplePojo() throws JsonProcessingException {

        SimplePojo simplePojo = new SimplePojo("value1", "value2");
        SimplePojo simplePojo2 = new SimplePojo();

        SimplePojo deserializedPojo = given().baseUri("https://01ce1d53-5b76-4df1-8d5b-0bb935aba2c1.mock.pstmn.io")
                .body(simplePojo)
                .when().post("/postSimpleJson")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract()
                .response()
                .as(SimplePojo.class);

        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(deserializedPojo);
        String jsonPayload = mapper.writeValueAsString(simplePojo);
        assertThat(mapper.readTree(jsonResult), equalTo(mapper.readTree(jsonPayload)));
    }


}
