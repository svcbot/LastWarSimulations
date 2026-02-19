package dev.svcbot;

import dev.svcbot.boss.BossStrategyResult;

import java.util.OptionalDouble;
import java.util.function.Supplier;

public class BossStrategySimulation extends Simulation<BossStrategyResult> {

    public BossStrategySimulation(int repeats, Supplier<? extends Strategy<BossStrategyResult>> supplier) {
        super(repeats, supplier);
    }

    @Override
    public void evaluateStrategyResults() {
        OptionalDouble averageMedals = results.stream().map(r -> r.medals).mapToDouble(a -> a).average();

        OptionalDouble averageGold = results.stream().map(r -> r.goldInMillions).mapToDouble(a -> a).average();

        OptionalDouble averageBossesSummoned = results.stream().map(r -> r.bossesSummoned).mapToDouble(a -> a).average();
        OptionalDouble averageBossesSlain = results.stream().map(r -> r.bossesSlayed).mapToDouble(a -> a).average();

        if (averageMedals.isPresent()) {
            System.out.printf("Average medals: %.2f%n", averageMedals.getAsDouble());
        }

        if  (averageGold.isPresent()) {
            System.out.printf("Average gold %.2f M %n", averageGold.getAsDouble());
        }

        if (averageBossesSummoned.isPresent()) {
            System.out.printf("Average bosses summoned: %.2f %n", averageBossesSummoned.getAsDouble());
        }

        if  (averageBossesSlain.isPresent()) {
            System.out.printf("Average bosses slayed: %.2f%n", averageBossesSlain.getAsDouble());
        }

        //printHistogram(group);

        System.out.printf("Simulation of %s is complete%n", strategySupplier.get().getClass().getSimpleName());
        System.out.println();
    }
}
