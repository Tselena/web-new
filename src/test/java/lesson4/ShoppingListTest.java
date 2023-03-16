package lesson4;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ShoppingListTest extends AbstractTest{

    @Test
    void AddDeleteItemInShoppingListTest(){
        String id= given().spec(requestSpecification)
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .body("{\n"
                        +"\"aisles\": [\n"
                           +"{\n"
                              +"\"aisle\": \"Baking\",\n"
                              +"\"items\": [\n"
                                   +"{\n"
                                         +"\"id\": 115388,\n"
                                         +"\"name\": \"baking powder\",\n"
                                         +"\"measures\": {\n"
                                              +"\"original\": {\n"
                                                   +"\"amount\": 1.0,\n"
                                                   +"\"unit\": \"package\"\n"
                                              +"},\n"
                                         +"\"metric\": {\n"
                                                   +"\"amount\": 1.0,\n"
                                                   +"\"unit\": \"pkg\"\n"
                                              +"},\n"
                                         +"\"us\": {\n"
                                                   +"\"amount\": 1.0,\n"
                                                   +"\"unit\": \"pkg\"\n"
                                              +"}\n"
                                         +"},\n"
                                         +"\"pantryItem\": false,\n"
                                         +"\"aisle\": \"Baking\",\n"
                                         +"\"cost\": 0.71,\n"
                                         +"\"ingredientId\": 18369\n"
                                   +"}\n"
                              +"]\n"
                           +"}\n"
                        +"],\n"
                        +"\"cost\": 0.71,\n"
                        +"\"startDate\": 1588291200,\n"
                        +"\"endDate\": 1588896000\n"
                        +"}\n")
                .when()
                .post("https://api.spoonacular.com/mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/shopping-list/items")
                .then()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .when()
                .delete(getUrl()+"mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/shopping-list/items/"+id)
                .then()
                .extract().body().jsonPath();
    }



    @Test
    void GetShoppingList(){
        given()
                .queryParam("hash", "d735d9fcc5dc8ee4973c88faeb2f0d0e7c89c2fd")
                .when()
                .get(getUrl()+"mealplanner/495e9adc-75fc-4e65-af69-4c7dac92d9f8/shopping-list")
                .then()
                .extract().body().jsonPath();
    }
}
