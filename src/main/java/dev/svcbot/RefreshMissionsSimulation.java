package dev.svcbot;

import dev.svcbot.tickets.RefreshMissionsResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;

public class RefreshMissionsSimulation extends Simulation<RefreshMissionsResult> {
    public RefreshMissionsSimulation(int repeats, Supplier<? extends Strategy<RefreshMissionsResult>> supplier) {
        super(repeats, supplier);
    }

    @Override
    public void evaluateStrategyResults() {
        Optional<Integer> min = results.stream().map(r -> r.ticketsSpent).min(Integer::compareTo);
        Optional<Integer> max = results.stream().map(r -> r.ticketsSpent).max(Integer::compareTo);
        OptionalDouble average = results.stream().map(r -> r.ticketsSpent).mapToDouble(a -> a).average();
//        Map<Integer, List<Integer>> group = results.stream().map(r -> r.ticketsSpent).collect(Collectors.groupingBy(Function.identity()));

        if (min.isPresent() && average.isPresent()) {
            System.out.printf("Min %d%n", min.get());
            System.out.printf("Max %d%n", max.get());
            System.out.printf("Average %.2f%n", average.getAsDouble());
        }

        //printHistogram(group);

        System.out.printf("Simulation of %s is complete%n", strategySupplier.get().getClass().getSimpleName());
        System.out.println();
    }

    private void printHistogram(Map<Integer, List<Integer>> group) {
        for (Integer i : group.keySet()) {
            System.out.printf("%s, %s%n", i, group.get(i).size());
        }
    }
}
