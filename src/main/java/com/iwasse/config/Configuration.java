package com.iwasse.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:api.properties"})
public interface Configuration extends Config {

    @Key("base-uri")
    String baseURI();
    @Key("base-path")
    String basePath();
}
