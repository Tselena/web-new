package lesson4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddDeleteMealPlanTest extends AbstractTest {

    @Test
    void AddDeleteMealPlanExampleTest(){

        String id= given().spec(requestSpecification)
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 banana\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/items")
                .then()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given().spec(requestSpecification)
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .delete("https://api.spoonacular.com/mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/items/" + id)
                .then()
                .extract()
                .jsonPath();

    }

    @Test
    void AddDeleteMealPlanTest(){

        String id= given().spec(requestSpecification)
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .body("{\n"
                        + " \"date\": 1589500800,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"MENU_ITEM\",\n"
                        + " \"value\": {\n"
                        + " \"id\": \"378557\",\n"
                        + " \"servings\": \"1\",\n"
                        + " \"title\": \"Pizza 73 BBQ Steak Pizza, 9\",\n"
                        + " \"imageType\": \"png\"\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/items")
                .then()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given().spec(requestSpecification)
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .delete("https://api.spoonacular.com/mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/items/" + id)
                .then()
                .extract()
                .jsonPath();

    }

}
