package dev.svcbot;

import dev.svcbot.boss.*;
import dev.svcbot.tickets.AlwaysMegaRefreshStrategy;
import dev.svcbot.tickets.AlwaysRefreshStrategy;
import dev.svcbot.tickets.SwitchOnFourStrategy;

public class Main {

    public static void main(String[] args) {

//        simulateBossStrategies();

        simulateTicketStrategies();

    }

    private static void simulateBossStrategies() {
        int energy = 1000;

        System.out.printf("Starting energy of each simulation: %d%n", energy);

        new BossStrategySimulation(1000, () -> new AttackOwnBossesStrategy(energy)).simulate();

        new BossStrategySimulation(1000, () -> new AssistOwnBossStrategy(energy)).simulate();

        new BossStrategySimulation(1000, () -> new IgnoreOwnBossStrategy(energy)).simulate();

        new BossStrategySimulation(1000, () -> new AttackBossesExclusivelyStrategy(energy)).simulate();

        new BossStrategySimulation(1000, () -> new Perform20RandomAssistsStrategy(energy)).simulate();
    }

    private static void simulateTicketStrategies() {
        new RefreshMissionsSimulation(1000, AlwaysMegaRefreshStrategy::new).simulate();

        new RefreshMissionsSimulation(1000, AlwaysRefreshStrategy::new).simulate();

        new RefreshMissionsSimulation(1000, SwitchOnFourStrategy::new).simulate();
    }
}
