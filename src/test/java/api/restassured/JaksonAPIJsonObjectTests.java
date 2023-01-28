package api.restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class JaksonAPIJsonObjectTests {
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
    public void addWorkspacesPostMap() throws JsonProcessingException {
        ObjectMapper mapperMain = new ObjectMapper();
        ObjectNode nestedObjectNode = mapperMain.createObjectNode();
        nestedObjectNode.put("name", "myWorkspace2");
        nestedObjectNode.put("type", "personal");
        nestedObjectNode.put("description", "Test from postman");

        ObjectNode mainObjectNode = mapperMain.createObjectNode();
        mainObjectNode.set("workspace", nestedObjectNode);

        String mainObjectString = mapperMain.writeValueAsString(mainObjectNode);

        Response response = with().body(mainObjectString)
                .when().post("/workspaces");

        assertThat(response.path("workspace.name"), equalTo("myWorkspace2"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));
    }

}
