package Controller;

import GUI.FrenchToEnglishGUI;
import Logic.GameLogic;
import Logic.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Arrays;

public class FrenchToEnglishController {
    private FrenchToEnglishGUI view;
    private GameLogic model;
    private int cpt;

    public FrenchToEnglishController(FrenchToEnglishGUI view, GameLogic model){
        this.view = view;
        this.model = model;

        cpt = 0;
        List<Pair> listPhrases = Arrays.asList(
                new Pair("Le chat est sous la table.", "The cat is under the table."),
                new Pair("Mon chien court dans le parc.", "My dog runs in the park."),
                new Pair("La maison est près de la rivière.", "The house is near the river."),
                new Pair("L'école est grande et moderne.", "The school is big and modern."),
                new Pair("Je lis un livre sur les animaux.", "I am reading a book about animals."),
                new Pair("Il écrit avec un stylo bleu.", "He writes with a blue pen."),
                new Pair("Elle mange une pomme rouge.", "She eats a red apple."),
                new Pair("Je bois un peu d'eau.", "I drink some water."),
                new Pair("Le soleil est dans le ciel.", "The sun is in the sky."),
                new Pair("La lune est blanche ce soir.", "The moon is white tonight.")
        );

        List<String> shuffuledPhrases = GameLogic.shuffleFrenchPairs(listPhrases);

        this.view.getTextToTranslateLabel().setText(shuffuledPhrases.get(cpt));
        this.view.getSubmitButton().addActionListener(e -> {
            if (GameLogic.isPaired(this.view.getTextToTranslateLabel().getText(), this.view.getUserTextField().getText(), listPhrases)){
                this.view.getTextToTranslateLabel().setForeground(Color.GREEN);
                new Timer(50, e1 -> {
                    try {
                        Thread.sleep(500);
                        // Si le joueur a bon et que c'est son dernier tour, on affiche le texte en vert et on affiche le menu de fin.
                        if (cpt >= 3){
                            //End the game
                        }
                        else{
                            // Si le joueur a bon et que ce n'est pas son dernier tour, on affiche le texte en vert et on passe au suivant.
                            cpt += 1;
                            this.view.getTextToTranslateLabel().setText(shuffuledPhrases.get(cpt));
                            this.view.getTextToTranslateLabel().setForeground(Color.WHITE);
                            this.view.getUserTextField().setText("");
                        }
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }) {{
                    setRepeats(false);
                    start();
                }};
            }
            else{
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
        });
    }
}
