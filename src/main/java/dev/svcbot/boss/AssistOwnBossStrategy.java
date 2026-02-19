package dev.svcbot.boss;

public class AssistOwnBossStrategy extends BossStrategy {

    public AssistOwnBossStrategy(int energy) {
        super(energy);
        this.description = "Always assist to kill your own boss.";
    }

    @Override
    public BossStrategyResult call() {

        while (energy > 0) {
            attackGoldenZombie();

            if (random.nextFloat() < 0.1f) {
                Boss boss = generateBoss();
                result.bossesSummoned++;
                assistOwnBoss(boss);
            }
        }

        return result;
    }

}
