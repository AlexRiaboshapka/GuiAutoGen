package api.restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RequestPayloadComplexJsonTests {

    @BeforeClass
    public void setup() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://5e09b25a-c867-4177-9cae-701b213cc53b.mock.pstmn.io")
                .addHeader("Content-Type", "application/json")
                .addHeader("x-mock-match-request-body", "true")
                .log(LogDetail.ALL);

        RestAssured.requestSpecification = requestSpecBuilder.build();
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json; charset=utf-8")
                .log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void requestPayloadComplexJson() {
        List<Integer> idArrayList = new ArrayList<>();
        idArrayList.add(5);
        idArrayList.add(9);

        HashMap<String, Object> betterHashMap2 = new HashMap<>();
        betterHashMap2.put("id", idArrayList);
        betterHashMap2.put("type", "Chocolate");

        HashMap<String, Object> betterHashMap1 = new HashMap<>();
        betterHashMap1.put("id", "1001");
        betterHashMap1.put("type", "Regular");

        List<HashMap<String, Object>> betterHashMapList = new ArrayList<>();
        betterHashMapList.add(betterHashMap1);
        betterHashMapList.add(betterHashMap2);

        HashMap<String, List> bettersHashMap = new HashMap<>();
        bettersHashMap.put("batter", betterHashMapList);

        List<String> typeArrayList = new ArrayList<>();
        typeArrayList.add("test1");
        typeArrayList.add("test2");

        HashMap<String, Object> toppingHashMap2 = new HashMap<>();
        toppingHashMap2.put("id", "5002");
        toppingHashMap2.put("type", typeArrayList);

        HashMap<String, Object> toppingHashMap1 = new HashMap<>();
        toppingHashMap1.put("id", "5001");
        toppingHashMap1.put("type", "None");

        List<HashMap<String, Object>> toppingArrayList = new ArrayList<>();
        toppingArrayList.add(toppingHashMap1);
        toppingArrayList.add(toppingHashMap2);

        HashMap<String, Object> mainHashMap = new HashMap<>();
        mainHashMap.put("ppu", 0.55);
        mainHashMap.put("batters", bettersHashMap);
        mainHashMap.put("name", "Cake");
        mainHashMap.put("id", "0001");
        mainHashMap.put("type", "donut");
        mainHashMap.put("topping", toppingArrayList);


        given().body(mainHashMap)
                .when().post("/postComplexJson")
                .then().log().all();
    }

    @Test
    public void testComplexJson() {
        HashMap<String, Object> codeHashMap1 = new HashMap<>();
        codeHashMap1.put("hex", "#000");
        codeHashMap1.put("rgba", new int[]{255, 255, 255, 1});

        HashMap<String, Object> colorsHashMap1 = new HashMap<>();
        colorsHashMap1.put("category", "hue");
        colorsHashMap1.put("code", codeHashMap1);
        colorsHashMap1.put("color", "black");
        colorsHashMap1.put("type", "primary");

        HashMap<String, Object> codeHashMap2 = new HashMap<>();
        codeHashMap2.put("hex", "#FFF");
        codeHashMap2.put("rgba", new int[]{0, 0, 0, 1});

        HashMap<String, Object> colorsHashMap2 = new HashMap<>();
        colorsHashMap2.put("category", "value");
        colorsHashMap2.put("code", codeHashMap2);
        colorsHashMap2.put("color", "white");

        List<HashMap<String, Object>> colorsArrayList = new ArrayList<>();
        colorsArrayList.add(colorsHashMap1);
        colorsArrayList.add(colorsHashMap2);

        HashMap<String, Object> mainHashMap = new HashMap<>();
        mainHashMap.put("colors", colorsArrayList);

        given().body(mainHashMap)
                .when().post("/postComplexJson2")
                .then().log().all();
    }
}
