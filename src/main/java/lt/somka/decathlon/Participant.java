package lt.somka.decathlon;

import java.util.List;

public class Participant {
    private String name;
    private List<String> results;
    private Integer score;

    public Participant(String name, List<String> results) {
        this.name = name;
        this.results = results;
    }

    public Participant() {
    }

    public Double getEventResult(Integer eventNumber) {
        return Double.parseDouble(getResults().get(eventNumber));
    }

    public Double getLastEventResult() {
        String resultAsText = getResults().get(9);
        Integer minutes = Integer.parseInt(resultAsText.substring(0, resultAsText.indexOf(".")));
        Integer seconds = Integer.parseInt(resultAsText.substring(resultAsText.indexOf(".") + 1, resultAsText.lastIndexOf(".") - 1));
        Integer miliSeconds = Integer.parseInt(resultAsText.substring((resultAsText.lastIndexOf(".") + 1)).trim());
        Double result = (double) minutes * 60 + seconds + miliSeconds / 100;
        return result;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " " + results + ", total score " + score;
    }
}
