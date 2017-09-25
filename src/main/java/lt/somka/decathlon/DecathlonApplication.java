package lt.somka.decathlon;

import lt.somka.decathlon.calculations.PlacesCalculator;
import lt.somka.decathlon.calculations.ScoreCalculator;
import lt.somka.decathlon.input.InputFileReader;

import java.io.IOException;
import java.util.List;

public class DecathlonApplication {
    public static void main(String[] args) {
        InputFileReader reader = new InputFileReader();
        ScoreCalculator calc = new ScoreCalculator();
        List<Participant> participants;
        PlacesCalculator placesCalculator;
        try {
            participants = reader.readFile();
            for (Participant participant : participants) {
                calc.calculateScore(participant);
            }
            placesCalculator = new PlacesCalculator(participants);
            placesCalculator.sortParticipants();
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }

    }
}
