package lt.somka.decathlontest;

import lt.somka.decathlon.Participant;
import lt.somka.decathlon.input.InputFileReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReaderTest {
    private InputFileReader reader;
    private List<Participant> participants;

    @Before
    public void start() {
        reader = new InputFileReader();
        participants = new ArrayList<>();
    }

    @Test
    public void beforeReadingTheFileParticipantsListShouldBeEmpty() throws FileNotFoundException, IOException{
        reader.setInputFileName("decathlonInputTest");
        Assert.assertTrue(participants.isEmpty());
        participants = reader.readFile();
        Assert.assertNotNull(participants);
    }

    @Test
    public void readerShouldGetCorrectData() throws FileNotFoundException, IOException{
        reader.setInputFileName("decathlonInputTest");
        participants = reader.readFile();
        Assert.assertTrue(participants.get(0).getName().equals("Test name"));
        Assert.assertTrue(participants.get(0).getResults().get(1).equals("4.35"));
    }

}
