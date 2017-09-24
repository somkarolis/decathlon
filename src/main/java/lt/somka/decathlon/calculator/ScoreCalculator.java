package lt.somka.decathlon.calculator;

import lt.somka.decathlon.Participant;

// for track events Points = INT(A(B — P)C)
// for field events Points = INT(A(P — B)C)

        /*
        Parameters A,B and C values for different events
        Event	        A	        B	        C
        100 m	        25.4347	    18	        1.81
        Long jump	    0.14354	    220	        1.4
        Shot put	    51.39	    1.5	        1.05
        High jump	    0.8465	    75	        1.42
        400 m	        1.53775	    82	        1.81
        110 m hurdles	5.74352	    28.5	    1.92
        Discus throw	12.91	    4	        1.1
        Pole vault	    0.2797	    100	        1.35
        Javelin throw	10.14	    7	        1.08
        1500 m	        0.03768	    480	        1.85
        */

public class ScoreCalculator {

    //calculates event score where faster time = better score
    private Integer calculateTrackEvent(double A, double B, double C, Double result) {
        Integer score;
        score = (int)Math.round(A * Math.pow((B - result), C));
        return score;
    }

    //calculates event score where greater distance or height = better score
    private Integer calculateFieldEvent(double A, double B, double C, Double result) {
        Integer score;
        score = (int)Math.round(A * Math.pow((result - B), C));
        return score;
    }

    public Integer calculateScore(Participant participant) {
        Integer score =
                //100m
                calculateTrackEvent(25.4347, 18, 1.81, participant.getEventResult(0)) +

                //long jump
                calculateFieldEvent(0.14354, 220, 1.4, participant.getEventResult(1) * 100) +

                //shot put
                calculateFieldEvent(51.39, 1.5, 1.05, participant.getEventResult(2)) +

                //high jump
                calculateFieldEvent(0.8465, 75, 1.42, participant.getEventResult(3) * 100) +

                //400m
                calculateTrackEvent(1.53775, 82, 1.81, participant.getEventResult(4)) +

                //110m hurdles
                calculateTrackEvent(5.74352, 28.5, 1.92, participant.getEventResult(5)) +

                //discus throw
                calculateFieldEvent(12.91, 4, 1.1, participant.getEventResult(6)) +

                //pole vault
                calculateFieldEvent(0.2797, 100, 1.35, participant.getEventResult(7) * 100) +

                //Javelin throw
                calculateFieldEvent(10.14, 7, 1.08, participant.getEventResult(8)) +

                //1500m
                calculateTrackEvent(0.03768, 480, 1.85, participant.getLastEventResult());
        return score;
    }

}
