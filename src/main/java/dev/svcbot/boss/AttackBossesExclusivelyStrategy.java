package dev.svcbot.boss;

public class AttackBossesExclusivelyStrategy extends BossStrategy {

    public AttackBossesExclusivelyStrategy(int energy) {
        super(energy);
        this.description = "Spend all the energy to attack golden bosses exclusively";
    }

    @Override
    public BossStrategyResult call() {

        while (energy > 0) {
            Boss boss = generateBoss();
            slainAlliedBoss(boss);
        }

        return result;
    }
}
