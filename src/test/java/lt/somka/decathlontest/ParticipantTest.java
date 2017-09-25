package lt.somka.decathlontest;

import lt.somka.decathlon.Participant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ParticipantTest {
    private Participant participant;

    @Before
    public void start() {
        participant = new Participant();
    }

    @Test
    public void participantResultsShouldBeEmptyAtStart() {
        Assert.assertTrue(participant.getResults() == null);
    }

    @Test
    public void participantShouldHaveAName() {
        participant.setName("John");
        Assert.assertTrue(participant.getName().equals("John"));
    }

    @Test
    public void participantShouldHaveResults() {
        String[] results = new String[]{"13.01", "5.22", "8.77"};
        participant.setResults(Arrays.asList(results));
        Assert.assertFalse(participant.getResults() == null);
    }

    @Test
    public void getEventResultMethodShouldReturnDoubles() {
        String[] results = new String[]{"13.01", "5.22", "8.77"};
        participant.setResults(Arrays.asList(results));
        Assert.assertTrue(participant.getEventResult(0) == 13.01);
        Assert.assertTrue(participant.getEventResult(1) == 5.22);
        Assert.assertTrue(participant.getEventResult(2) == 8.77);
    }

    @Test
    public void lastEventResultShouldReturnSecondsCountAsDouble() {
        String[] results = new String[]{"13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"};
        participant.setResults(Arrays.asList(results));
        Assert.assertTrue(participant.getLastEventResult() == 410.76);
    }

}
