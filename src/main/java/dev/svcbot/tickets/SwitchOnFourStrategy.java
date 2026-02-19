package dev.svcbot.tickets;

import dev.svcbot.Strategy;

public class SwitchOnFourStrategy extends Strategy<RefreshMissionsResult> {
    public SwitchOnFourStrategy() {
        result = new RefreshMissionsResult();
        description = "Use normal refresh if there are more than 4 missions, otherwise mega refresh.";
    }

    @Override
    public RefreshMissionsResult call() {
        int tasks = 8;

        // initial tasks list. it is randomized. golden tasks a removed
        for (int i = 0; i < 8; i++) {
            if (random.nextFloat() >= 0.92f) {
                tasks--;
            }
        }

        while (tasks > 4) {
            for (int i = 0; i < tasks; i++) {
                if (random.nextFloat() >= 0.92f) {
                    tasks--;
                }
            }
            result.ticketsSpent++;
        }

        result.ticketsSpent += tasks * 4;

        return result;
    }
}
