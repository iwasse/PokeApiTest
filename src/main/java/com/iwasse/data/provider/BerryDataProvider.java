package com.iwasse.data.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class BerryDataProvider {

    private static Stream<Arguments> provideBerryNames() {
        return Stream.of(
                Arguments.of("cheri"),
                Arguments.of("chesto"),
                Arguments.of("pecha"),
                Arguments.of("rawst"),
                Arguments.of("aspear"),
                Arguments.of("leppa")
        );
    }
}
