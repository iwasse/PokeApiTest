package com.iwasse.test;

import com.iwasse.BaseAPI;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PokemonFunctionalTest extends BaseAPI {


    @Test
    @DisplayName("When I request a pokemon resource then should return his name in the response body")
    public void whenISearchPokemonByName_ThenShouldReturnHisName(){

        given()
               .log().all()
         .when()
                .get("/pokemon/charizard")
         .then()
                .statusCode(200)
                .body("name", equalTo("charizard"));

    }

    @Test
    @DisplayName("When I search for Charizard then it should be in Red version")
    public void whenIsearchForCharizard_ThenShouldBeInRedVersionGame(){

        given()
        .when()
            .get("/pokemon/charizard")
        .then()
            .statusCode(200)
            .body("game_indices.version.name", hasItem("red"));

    }

    @Test
    @DisplayName("When I search for Charizard then his type should be Fire and Flying")
    public void whenIsearchForCharizard_ThenHisTypeShouldBeFlyingAndFire(){

        given()
        .when()
            .get("/pokemon/charizard")
        .then()
            .statusCode(200)
            .body("types.type.name", hasItems("fire", "flying"));

    }

    @Test
    public void testeJsonPath(){

        ArrayList<String> abilities =
                given()
                .when()
                .get("/pokemon/charizard")
                    .then()
                    .statusCode(200)
                    .extract().path("moves.move.name.findAll{it.startsWith('mega')}");

        System.out.println(abilities);
        Assertions.assertEquals(2, abilities.size());
        Assertions.assertTrue(abilities.get(0).equalsIgnoreCase("MeGA-PuncH"));

    }

}

