package dev.svcbot.boss;

public class IgnoreOwnBossStrategy extends BossStrategy {

    public IgnoreOwnBossStrategy(int energy) {
        super(energy);
        this.description = "Kill golden zombies, but ignore all spawned bosses. Goal is to spawn as may as possible. \n0 assists. Not a viable strategy, since you want to assist as much as possible, but it represents a good baseline to compare to.";
    }

    @Override
    public BossStrategyResult call() {

        while (energy > 0) {
            attackGoldenZombie();

            if (random.nextFloat() < 0.1f) {
                Boss boss = generateBoss();
                result.bossesSummoned++;
                ignoreBoss(boss);
            }
        }

        return result;
    }
}
