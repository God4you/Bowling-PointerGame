public class bowlingGame {

    private int CurrentRoll = 0;
    private int[] rolls = new int[21];

    public void CurrentRoll(int downedPins) {
        rolls[CurrentRoll++] = downedPins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 0; frameIndex < rolls.length; frameIndex++) {
            if (isStrike(rollIndex)) { // strike
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex++; // increment by 1

            } else if (isSpare(rollIndex)) { // spare
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2; // increment by 2
            } else { // standard
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        System.out.println("Du fik strike!");
        return rolls[rollIndex] == 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isSpare(int rollIndex) {
        System.out.println("Du fik spare!");
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

}