package dev.svcbot.tickets;

import dev.svcbot.Strategy;

public class AlwaysMegaRefreshStrategy extends Strategy<RefreshMissionsResult> {

    public AlwaysMegaRefreshStrategy() {
        result = new RefreshMissionsResult();
        description = "Always use Mega Refresh to refresh all non golden missions.";
    }

    @Override
    public RefreshMissionsResult call() {
        int tasks = 8;

        // initial tasks list. it is randomized. golden tasks are removed
        for (int i = 0; i < 8; i++) {
            if (random.nextFloat() >= 0.92) {
                tasks--;
            }
        }

        result.ticketsSpent = tasks * 4;

        return result;
    }
}
