import org.junit.Before;
import org.junit.Test;

public class GameTest { // THIS CANNOT RUN - but im certian it should work, else i'll work more.
    private bowlingGame bowlingGame;

    public void missAllRolls() {
        bowlingGame = new bowlingGame();
        roll(20, 0); // all 20 rolls missed
        assertThat(bowlingGame.score(), is(0)); // expected 0
    }

    @Test // Testing that if it only hit ones in every roll = 20
    public void allRollsOfOnes() {
        bowlingGame = new bowlingGame();
        roll(20, 1); // 20 x of ones
        assertThat(bowlingGame.score(), is(20)); // test should be 20 of ones.
    }

    @Test
    public void spareFollowedByFive() {
        bowlingGame = new bowlingGame();
        bowlingGame.CurrentRoll(7); // first rollindex (0) with 7 pinsHit points
        bowlingGame.CurrentRoll(3); // first rollindex+1 (1) with 3 pinsHit points - 7+3 = 10 = Spare!
        bowlingGame.CurrentRoll(5); // first rollindex+2 (2) with 5 pinsHit points = 15 for the first frame & 20
                                    // secound frame
        roll(17, 0); // 17 zeroes (20 rolls in total)
        assertThat(bowlingGame.score(), is(20)); // the end game result will be 16.
    }

    @Test
    public void strikeFollowedByFiveByTwo() {
        bowlingGame = new bowlingGame();
        bowlingGame.CurrentRoll(10); // first rollindex (0) with 10 pinsHit points - Strike! = first frame = 17
                                     // pinsHit.
        bowlingGame.CurrentRoll(5); // first rollindex+1 (1) with 5 pinsHit points
        bowlingGame.CurrentRoll(2); // first rollindex+2 (2) with 2 pinsHit points 5+2 = 7 for the secound frame.
        roll(16, 0); // 16 zeroes (20 rolls in total)
        assertThat(bowlingGame.score(), is(24)); // the end game result will be 24.
    }

    // methode roll for the amount pins is down in that roll.
    private void roll(int amount, int pinsHit) {
        bowlingGame = new bowlingGame();
        for (int i = 0; i < amount; i++) {
            bowlingGame.CurrentRoll(pinsHit);
        }
    }

}