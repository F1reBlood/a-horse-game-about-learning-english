package Controller;

import GUI.FrenchToEnglishGUI;
import Logic.CoreLogic;
import Logic.FrenchToEnglishLogic;
import Logic.Pair;
import Logic.ScoreManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class FrenchToEnglishController {
    private FrenchToEnglishGUI view;
    private FrenchToEnglishLogic model;
    private int cpt;
    private int nbTours;
    private ScoreManager scoreManager;

    public FrenchToEnglishController(FrenchToEnglishGUI view, FrenchToEnglishLogic model){
        this.view = view;
        this.model = model;

        scoreManager = new ScoreManager();

        nbTours = 5;
        cpt = 0;
        List<Pair> listPhrases = Arrays.asList(
                new Pair("Le chat est sous la table.", "The cat is under the table."),
                new Pair("Mon chien court dans le parc.", "My dog runs in the park."),
                new Pair("La maison est près de la rivière.", "The house is near the river."),
                new Pair("L'école est grande et moderne.", "The school is big and modern."),
                new Pair("Je suis en train de lire un livre sur les animaux.", "I am reading a book about animals."),
                new Pair("Il est en train d'écrire avec un stylo bleu.", "He is writing with a blue pen."),
                new Pair("Elle est en train de manger une pomme rouge.", "She is eating a red apple."),
                new Pair("Je suis en train de boire un peu d'eau.", "I am drinking some water."),
                new Pair("Le soleil est dans le ciel.", "The sun is in the sky."),
                new Pair("La lune est blanche ce soir.", "The moon is white tonight.")
        );

        List<String> shuffuledPhrases = this.model.shuffleFrenchPairs(listPhrases);

        this.view.getTextToTranslateLabel().setText(shuffuledPhrases.get(cpt));
        this.view.getSubmitButton().addActionListener(e -> {
            if (cpt >= nbTours){
                this.view.endFrenchToEnglish(scoreManager.getScore(), nbTours);
            }
            else{
                if (CoreLogic.isPaired(this.view.getTextToTranslateLabel().getText(), this.view.getUserTextField().getText(), listPhrases)){
                    // Si le joueur a bon, on affiche le texte en vert et on passe au suivant.
                    scoreManager.addScore(1);
                    this.view.getTextToTranslateLabel().setForeground(Color.GREEN);
                    new Timer(50, e1 -> {
                        try {
                            Thread.sleep(500);
                            cpt += 1;
                            this.view.getTextToTranslateLabel().setText(shuffuledPhrases.get(cpt));
                            this.view.getTextToTranslateLabel().setForeground(Color.WHITE);
                            this.view.getUserTextField().setText("");
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }) {{
                        setRepeats(false);
                        start();
                    }};
                }
                else{
                    // Si le joueur se trompe, on affiche le texte en rouge et on efface sa saisie
                    this.view.getTextToTranslateLabel().setForeground(Color.RED);
                    new Timer(50, e1 -> {
                        try {
                            Thread.sleep(500);
                            this.view.getTextToTranslateLabel().setForeground(Color.WHITE);
                            this.view.getUserTextField().setText("");
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }) {{
                        setRepeats(false);
                        start();
                    }};
                }
            }
        });
    }
}
