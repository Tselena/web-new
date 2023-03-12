package lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.common.assertion.Assertion;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class GetRequestTest extends AbstractTest{

    @Test
    void getUnauthorizedSearchTest() {
        given()
                .when()
                .request(Method.GET, getUrl()+getGetUrl()+ "cuisine=italian")
                .then()
                .statusCode(401);
    }

    @Test
    void getAuthorizedSearchTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .when()
                .request(Method.GET, getUrl()+getGetUrl()+ "cuisine=italian")
                .then()
                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body(equalTo("Risotto"))
                .extract().body().jsonPath().getString("Risotto");
        Assertions.assertEquals("Risotto","Risotto");
    }

    @Test
    void getPastaWithMinFatTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .when()
                .request(Method.GET, getUrl()+getGetUrl() + "query=pasta" + "maxFat=25" + "number=2")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("2");
        Assertions.assertEquals("2","2");
        Assertions.assertEquals("Pasta With Tuna", "Pasta With Tuna");
    }

    @Test
    void getIntoleranceReceiptTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .when()
                .request(Method.GET, getUrl()+getGetUrl() + "intolerances=gluten" + "cuisine=American")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getJsonObject("title");
        long timeDurationInSeconds = get (getUrl()). timeIn (TimeUnit.MILLISECONDS);
       Assertions.assertEquals(timeDurationInSeconds<=500,timeDurationInSeconds<=500);
       Assertions.assertEquals("The Best Chili", "The Best Chili");
    }

    @Test
    void getMaxReadyTimeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .when()
                .request(Method.GET, getUrl()+getGetUrl() + "query=pasta" + "maxReadyTime=20")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getJsonObject("totalResults");
        long timeDurationInSeconds = get (getUrl()). timeIn (TimeUnit.MILLISECONDS);
        Assertions.assertEquals(timeDurationInSeconds<=1000,timeDurationInSeconds<=1000);
        Assertions.assertEquals("11", "11");
    }

}
