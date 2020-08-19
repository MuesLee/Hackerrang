package de.ts.hackerrang.arraymanipulation;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

final class TestData {

    static Stream<Arguments> puzzleArguments() {
        return Stream.of(
                Arguments.of(10, new int[][]{
                }, 0),
                Arguments.of(10, new int[][]{
                        {1, 10, 3}
                }, 3),
                Arguments.of(10, new int[][]{
                        {1, 10, 3},
                        {1, 10, 2}
                }, 5),
                Arguments.of(10, new int[][]{
                        {1, 5, 3},
                        {6, 10, 4}
                }, 4),
                Arguments.of(10, new int[][]{
                        {1, 5, 3},
                        {4, 8, 7},
                        {6, 9, 1}
                }, 10),
                Arguments.of(10, new int[][]{
                        {2, 3, 603},
                        {1, 1, 286},
                        {4, 4, 882}
                }, 882),
                Arguments.of(5, new int[][]{
                        {1, 2, 100},
                        {2, 5, 100},
                        {3, 4, 100}
                }, 200),
                Arguments.of(10, new int[][]{
                        {2, 6, 8},
                        {3, 5, 7},
                        {1, 8, 1},
                        {5, 9, 15}
                }, 31)
        );
    }

    static Stream<Arguments> performanceArguments() {
        return Stream.of(
                Arguments.arguments("/arraymanipulation/arraymanipulation_1000000_operations_1.txt", 2510535321L),
                Arguments.arguments("/arraymanipulation/arraymanipulation_1000000_operations_2.txt", 2497169732L)
        );
    }
}
