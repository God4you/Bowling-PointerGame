public class bowlingGame { // MY take of giving this task a go.
    // My algorithm that i havent implemented correctly.

    private int CurrentRoll = 0; // counter roll
    private int[] rolls = new int[21]; // size array 21

    public void CurrentRoll(int pinsHit) {
        rolls[CurrentRoll++] = pinsHit; // store all the rolls
    }

    // calculation of the score
    // rollIndex + rollIndex+1 = one frame
    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 0; frameIndex < rolls.length; frameIndex++) {
            if (isStrike(rollIndex)) { // Strike!
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2]; // add the next two rolls to Strike score
                rollIndex++; // increment by 1

            } else if (isSpare(rollIndex)) { // Spare!
                score += 10 + rolls[rollIndex + 2]; // add the very next roll to Spare score
                rollIndex += 2; // increment by 2
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }

    // if the RollIndex (0) is equal 10 = Strike
    // invoke this methode
    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    // if the RollIndex (0) + rollIndex+1 is equal 10 = Spare
    // invoke this methode
    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

}