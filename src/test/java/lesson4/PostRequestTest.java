package lesson4;

import io.restassured.http.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class PostRequestTest extends AbstractTest {
    @Test
    void postAmericanCuisineTest(){
        given().spec(requestSpecification)
                .formParam("title","American")
                .when()
                .post(getUrl()+"recipes/cuisine?language=en")
                .then()
                .extract().body().jsonPath();
    }

    @Test
    void postGreekCuisineTest(){
        given().spec(requestSpecification)
                .formParam("title","Greek-Style Baked Fish: Fresh, Simple, and Delicious")
                .when()
                .post(getUrl()+"recipes/cuisine?language=en")
                .then()
                .extract().body().jsonPath();
        Assertions.assertEquals("Greek", "Greek");
    }

    @Test
    void postGermanCuisineTest(){
        given().spec(requestSpecification)
                .formParam("title","Smokey Rainbow Chilli")
                .when()
                .post(getUrl()+"recipes/cuisine?language=de")
                .then()
                .extract().body().jsonPath();
        Assertions.assertEquals("Greek", "Greek");
    }

    @Test
    void postRussianCuisineTest(){
        given().spec(requestSpecification)
                .formParam("title","toast")
                .when()
                .post(getUrl()+"recipes/cuisine?language=en")
                .then()
                .extract().body().jsonPath();
        Assertions.assertEquals("toast", "toast");
    }

    @Test
    void postCubainCuisineTest(){
        given().spec(requestSpecification)
                .formParam("cuisine","Cubain")
                .when()
                .post(getUrl()+"recipes/cuisine?language=en")
                .then()
                .extract().body().jsonPath();
        Assertions.assertEquals("Cubain", "Cubain");
    }
}
