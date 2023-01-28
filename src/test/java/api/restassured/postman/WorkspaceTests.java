package api.restassured.postman;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class WorkspaceTests {
    @BeforeClass
    public void setup() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://api.getpostman.com")
                .addHeader("x-api-key", "PMAK-63d1ab57fc57d065cb636e63-67f32cf75b2e865aeb13ccc5bd7af8bcd7")
                .log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8").log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void getWorkspaces() {
        given().when().get("/workspaces");
    }


    @Test
    public void addWorkspacesPost() {
        String payload = "{    \"workspace\": \n" +
                "        {\n" +
                "            \"name\": \"myWorkspace2\",\n" +
                "            \"type\": \"personal\",\n" +
                "            \"description\": \"Test from postman\"\n" +
                "        }\n" +
                "}";

        Response response = with().body(payload)
                .when().post("/workspaces");

        assertThat(response.path("workspace.name"), equalTo("myWorkspace2"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));
    }

    @Test
    public void updateWorkspacesPut() {
        String id = "7b5df703-0552-4e99-8d2f-7059cdcc9544";
        String payload = "{    \"workspace\": \n" +
                "        {\n" +
                "            \"name\": \"myWorkspace2updated2\",\n" +
                "            \"type\": \"personal\",\n" +
                "            \"description\": \"Test from postman updated\"\n" +
                "        }\n" +
                "}";

        Response response = with().body(payload)
                .pathParam("id", id)
                .when().put("/workspaces/{id}");

        assertThat(response.path("workspace.name"), equalTo("myWorkspace2updated2"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));
    }

    @Test
    public void deleteWorkspacesDelete() {
        String id = "66aabaca-bf44-4355-9815-37bde3e63e25";

        with()
                .pathParam("id", id)
                .when().delete("/workspaces/{id}");
    }

    @Test
    public void addWorkspacesPostFile() {
        File file = new File("src/test/resources/restpayload/CreateWorkspacePayload.json");

        Response response = with().body(file)
                .when().post("/workspaces");

        assertThat(response.path("workspace.name"), equalTo("myWorkspace2"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));
    }

    @Test
    public void addWorkspacesPostMap() throws JsonProcessingException {
        HashMap<String, Object> workspaceObject = new HashMap<>();
        HashMap<String, String> nestedObject = new HashMap<>();
        nestedObject.put("name", "myWorkspace2");
        nestedObject.put("type", "personal");
        nestedObject.put("description", "Test from postman");
        workspaceObject.put("workspace", nestedObject);

        ObjectMapper mapper = new ObjectMapper();
        String mainObjectString = mapper.writeValueAsString(workspaceObject);

        Response response = with().body(mainObjectString)
                .when().post("/workspaces");

        assertThat(response.path("workspace.name"), equalTo("myWorkspace2"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));
    }

    @Test
    public void addWorkspacesPostMapArrayList() {

        HashMap<String, String> obj5001 = new HashMap<>();
        obj5001.put("id", "5001");
        obj5001.put("type", "None");

        HashMap<String, String> obj5002 = new HashMap<>();
        obj5001.put("id", "5002");
        obj5001.put("type", "Glazed");
        List<Map> list = new ArrayList<>();
        list.add(obj5001);
        list.add(obj5002);

        Response response = with().body(list)
                .when().post("/workspaces");

        assertThat(response.path("workspace.name"), equalTo("myWorkspace2"));
        assertThat(response.path("workspace.id"), matchesPattern("^[a-z0-9-]{36}$"));
    }
}
