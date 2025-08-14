package Controller;

import GUI.FrenchToEnglishGUI;
import Logic.FrenchToEnglishLogic;

public class FrenchToEnglishController {
    private FrenchToEnglishGUI view;
    private FrenchToEnglishLogic model;

    public FrenchToEnglishController(FrenchToEnglishGUI view, FrenchToEnglishLogic model){
        this.view = view;
        this.model = model;


    }
}
