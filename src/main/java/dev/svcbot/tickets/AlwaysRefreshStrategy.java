package dev.svcbot.tickets;

import dev.svcbot.Strategy;

public class AlwaysRefreshStrategy extends Strategy<RefreshMissionsResult> {

    public AlwaysRefreshStrategy() {
        result = new RefreshMissionsResult();
        description = "Start all golden missions, refresh until gold appears, until there are no more missions.";
    }

    @Override
    public RefreshMissionsResult call() {
        int tasks = 8;

        // initial tasks list. it is randomized. golden tasks a removed
        for (int i = 0; i < 8; i++) {
            if (random.nextFloat() >= 0.92) {
                tasks--;
            }
        }

        while (tasks > 0) {
            for (int i = 0; i < tasks; i++) {
                if (random.nextFloat() >= 0.92f) {
                    tasks--;
                }
            }
            result.ticketsSpent++;
        }

        return result;
    }
}
