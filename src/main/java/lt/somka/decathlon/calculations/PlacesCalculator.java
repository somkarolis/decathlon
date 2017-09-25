package lt.somka.decathlon.calculations;

import lt.somka.decathlon.Participant;

import java.util.*;
import java.util.stream.Collectors;

public class PlacesCalculator {
    private List<Participant> participants;
    private Map<Participant, String> participantsWithPlaces;

    public PlacesCalculator(List<Participant> participants) {
        this.participants = participants;
        participantsWithPlaces = new HashMap<>();
    }

    public void sortParticipants() {
        participants.sort(Comparator.comparing(Participant::getScore).reversed());
    }

    public Map<Participant, String> calculatePlaces() {
        String place;
        Integer placeCount = 1;
        int i = 0;
        while (i < participants.size()) {
            Integer compareCount = 1;
            if (i + 1 != participants.size()) {
                while (participants.get(i).getScore() == participants.get(i + compareCount).getScore()) {
                    compareCount++;
                }
            }
            if (compareCount == 1) {
                place = "" + placeCount;
            } else {
                place = "" + placeCount + "-" + (placeCount + compareCount - 1);
            }
            int temp = placeCount;
            int j = 0;
            while (j < compareCount) {
                participantsWithPlaces.put(participants.get(i), place);
                j++;
                i++;
                placeCount++;
            }
        }

        //returns sorted map
        return participantsWithPlaces.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Map<Participant, String> getParticipantsWithPlaces() {
        return participantsWithPlaces;
    }
}
