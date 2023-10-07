package com.iwasse;

import com.iwasse.config.Configuration;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class BaseAPI {

    @BeforeAll
    public static void beforeAllTests() {
        Configuration cfg = ConfigFactory.create(Configuration.class);

        baseURI = cfg.baseURI();
        basePath = cfg.basePath();

        System.out.println("url: " + baseURI);

        RestAssured.useRelaxedHTTPSValidation();

    }

}
