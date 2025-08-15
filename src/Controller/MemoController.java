package Controller;

import GUI.MainMenu;
import GUI.MemoGUI;
import Logic.CoreLogic;
import Logic.MemoLogic;
import Logic.ScoreManager;
import Logic.Pair;

import javax.swing.*;
import java.util.Hashtable;
import java.util.List;

public class MemoController {
    private MemoGUI view;
    private MemoLogic model;
    private ScoreManager scoreLogic;
    private List<Pair> pairList;

    public MemoController(MemoGUI view, MemoLogic model, List<Pair> pairList){
        this.view = view;
        this.model = model;
        this.pairList = pairList;

        scoreLogic = new ScoreManager();
        scoreLogic.setScore(100);

        // Sépare les mots des paires afin de faire une liste mélangée de mots
        List<String> mots = this.model.listMots(pairList);

        // Crée un dictionnaire qui relie un mot au bouton portant ce mot
        Hashtable<String, JButton> buttons = new Hashtable<>();

        // Crée les boutons et les associe chacun à un mot différent, leur ajoute un style, les ajoute au dictionnaire et les affiche
        for (int i = 0; i < mots.size(); i++) {
            JButton button = new JButton(mots.get(i));
            MainMenu.addStyleToButton(button);
            buttons.put(mots.get(i), button);
            button.addActionListener(e -> {
                showOneButton(buttons, button);
                buttons.forEach((mot, buttonBoucle) -> {
                    // On parcourt tous les boutons, si toutes les paires ont été trouvées, le jeu est fini et on affiche l'écran de fin.
                    if (this.model.isEveryPairsFound(buttons)){
                        this.view.endMemo(this.pairList, scoreLogic.getScore());
                    }
                    // Si une paire a été trouvée, on grise les boutons
                    if (CoreLogic.isPaired(button.getText(), buttonBoucle.getText(), this.pairList)){
                        button.setEnabled(false);
                        buttonBoucle.setEnabled(false);
                    }
                    // Si on clique sur 2 boutons sans trouver de paire, on retourne les boutons face caché après 1/2 seconde
                    else if (!(buttonBoucle.getText().isEmpty()) && !(buttonBoucle.equals(button)) && buttonBoucle.isEnabled()){
                        new Timer(50, e2 -> {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                            hideOneButton(button);
                            hideOneButton(buttonBoucle);
                            scoreLogic.removeScore(5);
                        }) {{
                            setRepeats(false);
                            start();
                        }};
                    }
                });
            });
            this.view.getPanel().add(button);
        }

        // Crée un timer de 50ms puis gèle l'écran afin que le joueur puisse regarder les cartes.
        // Gèle l'écran après 50ms pour éviter que l'écran soit vide lorsqu'il est gelé
        new Timer(50, e -> {
            try {
                // Laisse l'utilisateur voir les cartes pendant 3 secondes
                Thread.sleep(3000);
                // Cache toutes les cartes
                hideAllButtons(buttons);

            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }) {{
            // Le timer ne se lance qu'une seule fois
            setRepeats(false);
            start();
        }};
    }

    // Affiche le mot (key) du dictionnaire buttons sur le bouton associé (fait ça pour tous les boutons du dictionnaire)
    private void showAllButtons(Hashtable<String, JButton> buttons){
        buttons.forEach((mot, button) ->{
            button.setText(mot);
        });
    }

    // Supprime le texte sur tous les boutons du dictionnaire buttons (fait ça pour tous les boutons du dictionnaire)
    private void hideAllButtons(Hashtable<String, JButton> buttons){
        for (JButton button : buttons.values()){
            button.setText("");
        }
    }

    // Affiche le mot (key) du dictionnaire buttons sur le bouton associé (fait ça seulement pour le buttonToShow)
    private void showOneButton(Hashtable<String, JButton> buttons, JButton buttonToShow){
        buttons.forEach((mot, button) ->{
            if (button.equals(buttonToShow)){
                button.setText(mot);
            }
        });
    }

    // Supprime le texte sur un bouton
    private void hideOneButton(JButton buttonToHide){
        buttonToHide.setText("");
    }
}
