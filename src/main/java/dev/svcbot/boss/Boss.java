package dev.svcbot.boss;

class Boss {
    int level;

    public Boss(int level) {
        this.level = level;
    }

    int getAssistMedalReward() {
        return 40;
    }

    double getAssistGoldReward() {
        return 0.332 + level * 0.03;
    }

    int getSlainMedalsReward() {
        return 80;
    }

    double getSlainGoldReward() {
        return 0.5 + level * 0.05;
    }

    int getIntelMedalsReward() {
        return 190 + level * 10;
    }

    double getIntelGoldReward() {
        return 0.5 + level * 0.05;
    }
}
