package de.ts.hackerrang.arraymanipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
class StrategyPerformanceRaceTest {

    private static final Collection<ArrayManipulationStrategy> strategies = Arrays.asList(new SegmentTreeStrategy(), new SlopeTrackingStrategy());
    private static final Executor executor = Executors.newFixedThreadPool(strategies.size() * 2);
    private static final Map<String, Integer> winnerCount = new ConcurrentHashMap<>();

    private static Stream<Arguments> puzzleArguments() {
        return TestData.puzzleArguments();
    }

    private static Stream<Arguments> performanceArguments() {
        return TestData.performanceArguments();
    }

    @AfterAll
    static void publishRaceResult() {

        try (PrintWriter writer = new PrintWriter(Paths.get("target", "arraymanipulation_race_result.txt").toFile())) {
            winnerCount.forEach((winner, count) -> writer.write(winner + " won " + count + " time(s)."));
        } catch (Exception e) {
            // Many loss. Such tears
        }
    }

    @ParameterizedTest
    @MethodSource("puzzleArguments")
    void simpleTests(int givenArrayLength, int[][] givenAddOperations, long expectedMaxValue) throws Exception {

        RacingStrategyDecorator winner = race(new ProblemDefinition(givenArrayLength, givenAddOperations), strategies);

        Assertions.assertThat(winner.result).isEqualTo(expectedMaxValue);
    }

    @ParameterizedTest
    @MethodSource("performanceArguments")
    void performanceTests(String filePath, long expectedResult) throws Exception {

        Scanner scanner = new Scanner(Solution.class.getResourceAsStream(filePath));

        ProblemDefinition problemDefinition = Solution.parseProblemDefinition(scanner);

        RacingStrategyDecorator winner = race(problemDefinition, strategies);

        winnerCount.compute(winner.racerName, (key, value) -> value == null ? 1 : value + 1);

        Assertions.assertThat(winner.result).isEqualTo(expectedResult);
    }

    private RacingStrategyDecorator race(ProblemDefinition problemDefinition, Collection<ArrayManipulationStrategy> strategies) throws InterruptedException, ExecutionException, TimeoutException {
        return (RacingStrategyDecorator) CompletableFuture.anyOf(strategies.stream()
                .map(RacingStrategyDecorator::new)
                .map(decorator -> CompletableFuture.supplyAsync(() -> decorator.race(problemDefinition), executor))
                .toArray(CompletableFuture[]::new)).get(5, TimeUnit.MINUTES);
    }

    private static final class RacingStrategyDecorator {

        private final ArrayManipulationStrategy strategy;
        private final String racerName;
        private long result = -1;

        public RacingStrategyDecorator(ArrayManipulationStrategy strategy) {
            this.strategy = strategy;
            this.racerName = strategy.getClass().getSimpleName();
        }

        public RacingStrategyDecorator race(ProblemDefinition problemDefinition) {
            this.result = strategy.computeMaxSum(problemDefinition.getArrayLength(), problemDefinition.getIntervalSums());
            return this;
        }


    }
}
