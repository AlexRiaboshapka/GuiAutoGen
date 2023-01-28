package api.restassured;

import api.restassured.files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexResponse {

    /*1. Print No of courses returned by API

    2.Print Purchase Amount

    3. Print Title of the first course

    4. Print All course titles and their respective Prices

    5. Print no of copies sold by RPA Course

    6. Verify if Sum of all Course prices matches with Purchase Amount
       */

    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.coursePrice());
        int count = js.getInt("courses.size()");

    }
}
