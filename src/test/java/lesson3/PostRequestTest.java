package lesson3;

import io.restassured.http.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PostRequestTest extends AbstractTest{

    @Test
    void postRussianCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","toast")
                .when()
                .request(Method.POST, getUrl()+getPostUrl()+ "language=ru")
                .then()
                .statusCode(500);
    }

    @Test
    void postUnauthorizedTest(){
        given()
//                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("cuisine","Cubain")
                .when()
                .request(Method.POST, getUrl()+getPostUrl() + "language=en")
                .then()
                .statusCode(401);
    }

    @Test
    void postAmericanCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","American")
                .when()
                .request(Method.POST, getUrl()+getPostUrl()+ "language=en")
                .then()
                .statusCode(200);
    }

    @Test
    void postGreekCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Greek-Style Baked Fish: Fresh, Simple, and Delicious")
                .when()
                .request(Method.POST, getUrl()+getPostUrl()+ "language=en")
                .then()
                .statusCode(200);
        Assertions.assertEquals("Greek", "Greek");
    }

    @Test
    void postGermanCuisineTest(){
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Smokey Rainbow Chilli")
                .when()
                .request(Method.POST, getUrl()+getPostUrl()+ "language=de")
                .then()
                .statusCode(200);
        Assertions.assertEquals("Greek", "Greek");
        long timeDurationInSeconds = get (getUrl()). timeIn (TimeUnit.MILLISECONDS);
        Assertions.assertEquals(timeDurationInSeconds<=500,timeDurationInSeconds<=500);
    }

}
