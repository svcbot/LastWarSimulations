package dev.svcbot.boss;

public class AttackOwnBossesStrategy extends BossStrategy {

    public AttackOwnBossesStrategy(int energy) {
        super(energy);
        this.description = "Always kill your own boss after it is spawned.";
    }

    @Override
    public BossStrategyResult call() {

        while (energy > 0) {
            attackGoldenZombie();

            if (random.nextFloat() < 0.1f) {
                Boss boss = generateBoss();
                result.bossesSummoned++;

                slainBoss(boss);
            }
        }

        return result;
    }

}
