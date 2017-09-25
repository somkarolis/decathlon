package lt.somka.decathlon.ui;

import lt.somka.decathlon.Participant;
import lt.somka.decathlon.calculations.PlacesCalculator;
import lt.somka.decathlon.calculations.ScoreCalculator;
import lt.somka.decathlon.input.InputFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UI {
    private InputFileReader fileReader;
    private ScoreCalculator scoreCalculator;
    private PlacesCalculator placesCalculator;
    private Scanner reader;
    private List<Participant> participants;
    private String input;
    private String output;
    private Map<Participant, String> placedParticipants;

    public UI() {
        this.fileReader = new InputFileReader();
        this.scoreCalculator = new ScoreCalculator();
        this.reader = new Scanner(System.in);
    }

    public void initialize() {
        start();
        readFile();
        calculate();
    }

    private void start() {
        System.out.println("Please indicate input file name, default is 'Decathlon_input'.");
        input = reader.nextLine();
        System.out.println("Please indicate output file name:");
        output = reader.nextLine();
    }

    private void readFile() {
        fileReader.setInputFileName(input);
        try {
            participants = fileReader.readFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    private void calculate() {
        for (Participant participant : participants) {
            scoreCalculator.calculateScore(participant);
        }
        placesCalculator.sortParticipants();
        placedParticipants = placesCalculator.calculatePlaces();
    }
}
