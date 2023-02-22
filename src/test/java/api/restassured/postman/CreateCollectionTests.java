package api.restassured.postman;

import api.pojo.collections.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import logger.CustomLogger;
import org.json.JSONException;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class CreateCollectionTests {
    @BeforeClass
    public void beforeClass() throws IOException {
        Path path = Path.of("src/test/resources/credentials-key.json");
        PrintStream file = new PrintStream(new File("target/CreateCollectionTestsLog.txt"));
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://api.postman.com")
                .addHeader("x-api-key", Files.readString(path))
                .addHeader("Content-Type", "application/json")
                .setBasePath("/collections")
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL));
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8");
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }


    @Test
    public void createCollection() throws JsonProcessingException, JSONException {
        MyHeader myHeader1 = new MyHeader();
        myHeader1.setKey("Content-Type");
        myHeader1.setValue("application/json");
        myHeader1.setDescription("Content-Type");
        List<MyHeader> myHeaderList1 = new ArrayList<>();
        myHeaderList1.add(myHeader1);

        MyBody myBody1 = new MyBody();
        myBody1.setMode("raw");
        myBody1.setRaw("{\n\t\"data\": \"123\"\n}");

        MyRequestRequest myRequest1 =
                new MyRequestRequest("https://postman-echo.com/post", "POST",
                        "This is a sample POST Request", myHeaderList1, myBody1);


        RequestRootRequest requestRoot1 = new RequestRootRequest("Sample POST Request", myRequest1);
        List<RequestRootRequest> requestRootRequests1 = new ArrayList<>();
        requestRootRequests1.add(requestRoot1);

        FolderRequest folderRequest1 = new FolderRequest("Sample Collection Folder",
                "This is a sample collection", requestRootRequests1);


        MyBody myBody2 = new MyBody();
        myBody2.setMode("formdata");
        myBody2.setFormdata(new String[]{});

        List<MyHeader> myHeaderList2 = new ArrayList<>();

        MyRequestRequest myRequest2 = new MyRequestRequest("https://postman-echo.com/get",
                "GET", "Get request description", myHeaderList2, myBody2);
        RequestRootRequest requestRoot2 = new RequestRootRequest("Sample GET Request", myRequest2);

        List<RequestRootRequest> requestRootRequests2 = new ArrayList<>();
        requestRootRequests2.add(requestRoot2);


        FolderRequest folderRequest2 = new FolderRequest(requestRootRequests2);

        List<FolderRequest> myRequestList1 = new ArrayList<>();
        myRequestList1.add(folderRequest1);
        myRequestList1.add(folderRequest2);


        Info info1 = new Info();
        info1.setName("Sample Collection 2023 from Java");
        info1.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        info1.setDescription("This is a sample collection");
        CollectionRequest collection1 = new CollectionRequest(info1, myRequestList1);


        CollectionRootRequest collectionRoot = new CollectionRootRequest(collection1);

        String uid = given()
                .when()
                .body(collectionRoot)
                .post()
                .then().extract().response().path("collection.uid");

        CollectionRootResponse collectionRootResult =
                given()
                        .when()
                        .get("/" + uid)
                        .then().extract().response().as(CollectionRootResponse.class);

        ObjectMapper objectMapper = new ObjectMapper();
        String collectionRootResultString = objectMapper.writeValueAsString(collectionRootResult);
        String collectionRootString = objectMapper.writeValueAsString(collectionRoot);

        JSONAssert.assertEquals(collectionRootString, collectionRootResultString, new CustomComparator(JSONCompareMode.STRICT_ORDER,
                new Customization("collection.item[*].item[*].request.url", (o1, o2) -> true),
                new Customization("collection.item[*].request.url", (o1, o2) -> true)
        ));

        List<String> UrlRequestList = new ArrayList<>();
        List<String> UrlResponseList = new ArrayList<>();

        for (FolderRequest folderRequest : collection1.getItem()) {
            for (RequestRootRequest request : folderRequest.getItem()) {
                UrlRequestList.add(request.getRequest().getUrl());
            }
        }

        for (FolderResponse folderResponse : collectionRootResult.getCollection().getItem()) {
            for (RequestRootResponse requestRootResponse : folderResponse.getItem()) {
                UrlResponseList.add(requestRootResponse.getRequest().getUrl().getRaw());
            }
        }
        CustomLogger.logger.info("UrlRequestList: " + UrlRequestList);
        CustomLogger.logger.info("UrlResponseList: " + UrlResponseList);

        assertThat(UrlResponseList, containsInAnyOrder(UrlRequestList.toArray()));

        given()
                .when()
                .delete("/" + uid)
                .then().statusCode(200);
    }

    @Test
    public void createEmptyCollection() throws JsonProcessingException, JSONException {


        List<FolderRequest> myRequestList1 = new ArrayList<FolderRequest>();
        //myRequestList1.add(new FolderRequest());

        Info info1 = new Info();
        info1.setName("Sample Collection 2023 from Java");
        info1.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        info1.setDescription("This is a sample collection");
        CollectionRequest collection1 = new CollectionRequest(info1, myRequestList1);
        CollectionRootRequest collectionRoot = new CollectionRootRequest(collection1);

        String uid = given()
                .when()
                .body(collectionRoot)
                .post()
                .then().extract().response().path("collection.uid");

        CollectionRootResponse collectionRootResult =
                given()
                        .when()
                        .get("/" + uid)
                        .then().extract().response().as(CollectionRootResponse.class);

        ObjectMapper objectMapper = new ObjectMapper();
        String collectionRootResultString = objectMapper.writeValueAsString(collectionRootResult);
        String collectionRootString = objectMapper.writeValueAsString(collectionRoot);

        JSONAssert.assertEquals(collectionRootString, collectionRootResultString, new CustomComparator(JSONCompareMode.STRICT_ORDER,
                new Customization("collection.item[*].item[*].request.url", (o1, o2) -> true),
                new Customization("collection.item[*].request.url", (o1, o2) -> true)
        ));

        given()
                .when()
                .delete("/" + uid)
                .then().statusCode(200);
    }

}
