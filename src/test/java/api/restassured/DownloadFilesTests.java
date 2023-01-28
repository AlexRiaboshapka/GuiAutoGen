package api.restassured;

import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;

public class DownloadFilesTests {
    @Test
    public void downloadFileUsingBytes() throws IOException {

        byte[] bytes = given().baseUri("https://raw.githubusercontent.com")
                .when().get("/hubcio1809/Appium/Main_test_suite/ApiDemos.apk")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asByteArray();
        OutputStream os = new FileOutputStream(new File("target/ApiDemos.apk"));
        os.write(bytes);
        os.close();
    }

    @Test
    public void downloadFileUsingInputStream() throws IOException {

        InputStream inputStream = given().baseUri("https://raw.githubusercontent.com")
                .when().get("/hubcio1809/Appium/Main_test_suite/ApiDemos.apk")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asInputStream();
        byte[] bytes = inputStream.readAllBytes();
        OutputStream os = new FileOutputStream(new File("target/ApiDemos.apk"));
        os.write(bytes);
        os.close();
    }

}
