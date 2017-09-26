package lt.somka.decathlon.ui;

import lt.somka.decathlon.Participant;
import lt.somka.decathlon.calculations.PlacesCalculator;
import lt.somka.decathlon.calculations.ScoreCalculator;
import lt.somka.decathlon.input.InputFileReader;
import lt.somka.decathlon.output.XMLWriter;

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
    private String input = "Decathlon_input";
    private String output = "decathlon";
    private Map<Participant, String> placedParticipants;
    private XMLWriter writer;

    public UI() {
        this.fileReader = new InputFileReader();
        this.scoreCalculator = new ScoreCalculator();
        this.reader = new Scanner(System.in);
        this.writer = new XMLWriter();
    }

    public void initialize() {
        start();
        readFile();
        calculate();
        provideOutput();
    }

    private void start() {
        String temp;
        System.out.println("Please indicate input file name, default is 'Decathlon_input'.");
        temp = reader.nextLine();
        if (!temp.equals("")) {
            input = temp;
        }
        System.out.println("Please indicate output file name, default is 'decathlon'.");
        temp = reader.nextLine();
        if (!temp.equals("")) {
            output = temp;
        }
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
        this.placesCalculator = new PlacesCalculator(participants);
        placesCalculator.sortParticipants();
        placedParticipants = placesCalculator.calculatePlaces();
    }

    private void provideOutput() {
        writer.setOutput(output);
        writer.writeXML(placedParticipants);
    }
}
