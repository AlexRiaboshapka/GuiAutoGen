package api.restassured.files;

import io.restassured.path.json.JsonPath;

public class Helpers {
    public static JsonPath rawToJson(String response) {
        return new JsonPath(response);
    }
}
