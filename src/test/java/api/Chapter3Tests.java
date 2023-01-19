package api;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter3Tests {
    @DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }

    @Test(dataProvider = "zipCodesAndPlaces")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(
            String countryCode, String zipCode, String expectedPlaceName) {
        given().when().log().all()
                .get("http://zippopotam.us/" + countryCode + "/" + zipCode)
                .then()
                .assertThat().body("places[0].'place name'", equalTo(expectedPlaceName));
    }
}
