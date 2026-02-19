package dev.svcbot.boss;

class Boss {
    int rank; // Actual shown boss level increases in 5 increment. Rank is level/5

    public Boss(int rank) {
        this.rank = rank;
    }

    int getAssistMedalReward() {
        return 40;
    }

    double getAssistGoldReward() {
        return 0.332 + rank * 0.03;
    }

    int getSlainMedalsReward() {
        return 80;
    }

    double getSlainGoldReward() {
        return 0.5 + rank * 0.05;
    }

    int getIntelMedalsReward() {
        return 190 + rank * 10;
    }

    double getIntelGoldReward() {
        return 0.5 + rank * 0.05;
    }
}
