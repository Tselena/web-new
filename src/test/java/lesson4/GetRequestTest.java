package lesson4;

import io.restassured.http.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GetRequestTest extends AbstractTest{

    @Test
    void getAuthorizedSearchTest() {
        given().spec(getRequestSpecification())
                .when()
                .get(getUrl()+"recipes/complexSearch?cuisine=italian")
                .then()
                .extract().body().jsonPath().getString("Risotto");
        Assertions.assertEquals("Risotto","Risotto");
    }

    @Test
    void getPastaWithMinFatTest() {
        given().spec(getRequestSpecification())
                .when()
                .get(getUrl()+"recipes/complexSearch?query=pasta" + "maxFat=25" + "number=2")
                .then()
                .extract().body().jsonPath().getString("2");
        Assertions.assertEquals("2","2");
        Assertions.assertEquals("Pasta With Tuna", "Pasta With Tuna");
    }

    @Test
    void getIntoleranceReceiptTest() {
        given().spec(getRequestSpecification())
                .when()
                .get(getUrl()+"recipes/complexSearch?intolerances=gluten" + "cuisine=American")
                .then()
                .extract().body().jsonPath().getJsonObject("title");
        Assertions.assertEquals("The Best Chili", "The Best Chili");
    }

    @Test
    void getMaxReadyTimeTest() {
        given().spec(getRequestSpecification())
                .when()
                .get(getUrl()+"recipes/complexSearch?query=pasta" + "maxReadyTime=20")
                .then()
                .extract().body().jsonPath().getJsonObject("totalResults");
        Assertions.assertEquals("11", "11");
    }

    @Test
    void getKoreanReceiptTest() {
        given().spec(getRequestSpecification())
                .when()
                .get(getUrl()+"recipes/complexSearch?cuisine=Korean&query=kimchi")
                .then()
                .extract().body().jsonPath().getJsonObject("title");
        Assertions.assertEquals("Kimchi", "Kimchi");
    }

}
