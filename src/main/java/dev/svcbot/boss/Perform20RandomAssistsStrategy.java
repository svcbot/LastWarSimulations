package dev.svcbot.boss;

public class Perform20RandomAssistsStrategy extends BossStrategy {

    public Perform20RandomAssistsStrategy(int energy) {
        super(energy);
        description = "Assist 20 random bosses. No golden zombies kills, no own boss kills.";
    }

    @Override
    public BossStrategyResult call() {

        for (int i = 0; i < 20; i++) {
            Boss boss = generateBoss();
            assistBoss(boss);
        }

        return result;
    }
}
