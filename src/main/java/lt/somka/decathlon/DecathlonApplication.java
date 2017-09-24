package lt.somka.decathlon;

import lt.somka.decathlon.input.InputFileReader;

import java.io.IOException;
import java.util.List;

public class DecathlonApplication {
    public static void main(String[] args) {
        InputFileReader reader = new InputFileReader();
        try {
            List<Participant> participants = reader.readFile();
            for (Participant participant : participants) {
                System.out.println(participant);
            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }

    }
}