package lt.somka.decathlon.input;

import lt.somka.decathlon.Participant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {
    private List<Participant> participants;
    private String inputFileName;
    private BufferedReader br;

    public List<Participant> readFile() throws FileNotFoundException, IOException {
        participants = new ArrayList<>();
        br = new BufferedReader(new FileReader("C:/Users/somka/Documents/Java/decathlon/" + inputFileName + ".txt"));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(";");
            String name = fields[0];
            List<String> results = new ArrayList<>();
            for (int i = 1; i < fields.length; i++) {
                results.add(fields[i]);
            }
            participants.add(new Participant(name, results));
        }
        br.close();
        return participants;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }
}
