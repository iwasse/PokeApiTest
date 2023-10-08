package com.iwasse.berry;

import com.iwasse.BaseAPI;
import com.iwasse.data.provider.BerryDataProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
    Berries are small fruits that can provide HP and status condition restoration, stat enhancement,
    and even damage negation when eaten by Pokémon. Check out Bulbapedia for greater detail.
*/
public class BerryFunctionalTest extends BaseAPI {

    @ParameterizedTest
    @MethodSource("com.iwasse.data.provider.BerryDataProvider#provideBerryNames")
    @DisplayName("When I request a berry resource, it should return its name in the response body.")
    public void whenISearchBerryByName_ThenShouldReturnItsName(String berryName){

        given()
        .when()
            .get("/berry/" + berryName)
        .then()
            .log().all()
            .statusCode(200)
            .body("name", equalTo(berryName));

    }
}
