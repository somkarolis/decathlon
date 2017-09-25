package lt.somka.decathlontest;

import lt.somka.decathlon.Participant;
import lt.somka.decathlon.calculations.PlacesCalculator;
import lt.somka.decathlon.calculations.ScoreCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class PlacesCalculatorTest {
    private ScoreCalculator calc;
    private List<Participant> participants;
    private PlacesCalculator placesCalculator;

    @Before
    public void start() {
        participants = new ArrayList<>();
        calc = new ScoreCalculator();
        String[] results1 = new String[]{"12.04", "3.53", "7.79", "2.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"};
        String[] results2 = new String[]{"13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"};
        String[] results3 = new String[]{"14.04", "5.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"};
        String[] results4 = new String[]{"14.04", "5.53", "7.79", "1.55", "64.72", "18.74", "24.20", "2.40", "28.20", "6.50.76"};
        participants.add(new Participant("Participant1", Arrays.asList(results1)));
        participants.add(new Participant("Participant2", Arrays.asList(results2)));
        participants.add(new Participant("Participant3", Arrays.asList(results3)));
        participants.add(new Participant("Participant4", Arrays.asList(results4)));

        for (Participant participant : participants) {
            calc.calculateScore(participant);
        }
    }

    @Test
    public void participantsShouldBeSortedCorrectly() {
        placesCalculator = new PlacesCalculator(participants);
        placesCalculator.sortParticipants();
        Assert.assertTrue(participants.get(0).getScore() > participants.get(1).getScore());
        Assert.assertTrue(participants.get(0).getScore() > participants.get(2).getScore());
        Assert.assertTrue(participants.get(1).getScore() > participants.get(3).getScore());
        Assert.assertTrue(participants.get(2).getScore() > participants.get(3).getScore());
    }

    @Test
    public void participantsShouldHavePlacesAssigned() {
        placesCalculator = new PlacesCalculator(participants);
        placesCalculator.sortParticipants();
        Map<Participant, String> participantsWithPlaces = placesCalculator.calculatePlaces();
        Assert.assertFalse(participantsWithPlaces.values().isEmpty());
    }

    @Test
    public void correctPlacesShouldBeAssigned() {
        placesCalculator = new PlacesCalculator(participants);
        placesCalculator.sortParticipants();
        Map<Participant, String> participantsWithPlaces = placesCalculator.calculatePlaces();
        Assert.assertTrue(participantsWithPlaces.values().toArray()[0].equals("1"));
        Assert.assertTrue(participantsWithPlaces.values().toArray()[2].equals("2-3"));
        Assert.assertTrue(participantsWithPlaces.values().toArray()[3].equals("4"));
    }

    @Test
    public void ParticipantsWithDifferentScoresShouldHaveDifferentPlaces() {
        participants.remove(3);
        placesCalculator = new PlacesCalculator(participants);
        placesCalculator.sortParticipants();
        Map<Participant, String> participantsWithPlaces = placesCalculator.calculatePlaces();
        Assert.assertTrue(participantsWithPlaces.values().toArray()[0].equals("1"));
        Assert.assertTrue(participantsWithPlaces.values().toArray()[1].equals("2"));
        Assert.assertTrue(participantsWithPlaces.values().toArray()[2].equals("3"));
    }
}

