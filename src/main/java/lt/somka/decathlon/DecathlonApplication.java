package lt.somka.decathlon;

import lt.somka.decathlon.calculations.PlacesCalculator;
import lt.somka.decathlon.calculations.ScoreCalculator;
import lt.somka.decathlon.input.InputFileReader;
import lt.somka.decathlon.ui.UI;

import java.io.IOException;
import java.util.List;

public class DecathlonApplication {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.initialize();

    }
}
