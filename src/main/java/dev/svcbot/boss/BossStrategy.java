package dev.svcbot.boss;

import dev.svcbot.Strategy;

abstract class BossStrategy extends Strategy<BossStrategyResult> {

    int energy;
    BossStrategyResult result = new BossStrategyResult();

    public BossStrategy(int energy) {
        this.energy = energy;
    }

    public void attackGoldenZombie() {
        energy =- 10;
        result.medals += 10;
        result.goldInMillions += 0.268;
    }

    Boss generateBoss() {
        int level = random.nextInt(14, 22);
        return new Boss(level);
    }

    void ignoreBoss(Boss boss) {
        result.medals += boss.getIntelMedalsReward();
        result.goldInMillions += boss.getIntelGoldReward();
        energy += 20;
    }

    void assistBoss(Boss boss) {
        result.medals += boss.getAssistMedalReward();
        result.goldInMillions += boss.getAssistGoldReward();
    }

    void assistOwnBoss(Boss boss) {
        result.medals += boss.getAssistMedalReward();
        result.medals += boss.getIntelMedalsReward();
        result.goldInMillions += boss.getAssistGoldReward();
        result.goldInMillions += boss.getIntelGoldReward();
        energy += 20;
    }

    void slainBoss(Boss boss) {
        result.medals += boss.getSlainMedalsReward();
        result.medals += boss.getIntelMedalsReward();
        result.goldInMillions += boss.getSlainGoldReward();
        result.goldInMillions += boss.getIntelGoldReward();

        result.bossesSlayed++;
    }

    void slainAlliedBoss(Boss boss) {
        result.medals += boss.getSlainMedalsReward();
        result.goldInMillions += boss.getSlainGoldReward();
        energy -= 20;

        result.bossesSlayed++;
    }
}
