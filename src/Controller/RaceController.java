package Controller;

import GUI.RaceGUI;
import Logic.RaceLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceController {
    private RaceGUI view;
    private RaceLogic model;

    public RaceController(RaceGUI view, RaceLogic model) {
        this.view = view;
        this.model = model;

        List<String> listPhrases = Arrays.asList(
            "The cat is on the sofa.",
            "The dog is next to the tree.",
            "The house is small and white.",
            "The school is near the park.",
            "I am reading a red book.",
            "He is drawing with a black pen.",
            "She is eating a green apple.",
            "I am drinking cold water.",
            "The sun is yellow in the morning.",
            "The moon is round in the sky."
        );
    }
}
