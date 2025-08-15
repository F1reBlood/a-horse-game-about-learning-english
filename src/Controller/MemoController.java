package Controller;

import GUI.MainMenu;
import GUI.MemoGUI;
import Logic.GameLogic;
import Logic.Pair;

import javax.swing.*;
import java.util.Hashtable;
import java.util.List;

import static Logic.GameLogic.*;

public class MemoController {
    private MemoGUI view;
    private GameLogic model;
    private List<Pair> pairList;

    public MemoController(MemoGUI view, GameLogic model, List<Pair> pairList){
        this.view = view;
        this.model = model;
        this.pairList = pairList;

        // Sépare les mots des paires afin de faire une liste mélangée de mots
        List<String> mots = GameLogic.listMots(pairList);

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
                    if (isEveryPairsFound(buttons)){
                        this.view.endMemo(this.pairList, this.model.getScore());
                    }
                    // Si une paire a été trouvée, on grise les boutons
                    if (isPaired(button.getText(), buttonBoucle.getText(), this.pairList)){
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
                            this.model.removeScore(5);
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
}
