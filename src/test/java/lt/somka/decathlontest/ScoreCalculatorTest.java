package lt.somka.decathlontest;

import lt.somka.decathlon.Participant;
import lt.somka.decathlon.calculations.ScoreCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ScoreCalculatorTest {
    private Participant participant;
    private ScoreCalculator calc;

    @Before
    public void start() {
        String[] results = new String[]{"13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"};
        participant = new Participant("Tom", Arrays.asList(results));
        calc = new ScoreCalculator();
    }

    @Test
    public void scoreCalculationsShouldBeCorrect() {
        calc.calculateScore(this.participant);
        Assert.assertTrue(this.participant.getScore() == 3205);
    }
}
