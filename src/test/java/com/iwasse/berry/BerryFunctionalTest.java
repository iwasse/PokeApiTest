package com.iwasse.berry;

import com.iwasse.BaseAPI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
    Berries are small fruits that can provide HP and status condition restoration, stat enhancement,
    and even damage negation when eaten by Pokémon. Check out Bulbapedia for greater detail.
*/
public class BerryFunctionalTest extends BaseAPI {

    @Test
    @DisplayName("When I request a berry resource, it should return its name in the response body.")
    public void whenISearchBerryByName_ThenShouldReturnItsName(){

        given()
        .when()
            .get("/berry/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("name", equalTo("cheri"),
                    "growth_time", equalTo(3),
                    "flavors[0].flavor.name", equalTo("spicy"));

    }
}
