package lt.somka.decathlon;

import java.util.List;

public class Participant {
    private String name;
    private List<String> results;

    public Participant(String name, List<String> results) {
        this.name = name;
        this.results = results;
    }

    public Participant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return name + " " + results;
    }
}
