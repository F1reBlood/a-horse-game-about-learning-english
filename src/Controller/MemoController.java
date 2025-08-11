package Controller;

import GUI.MainMenu;
import GUI.MemoGUI;
import Logic.MemoLogic;
import Logic.Pair;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MemoController {
    private MemoGUI view;
    private MemoLogic model;
    private List<Pair> pairList;

    public MemoController(MemoGUI view, MemoLogic model, List<Pair> pairList){
        this.view = view;
        this.model = model;
        this.pairList = pairList;

        // Sépare les mots des paires afin de faire une liste mélangée de mots
        List<String> mots = MemoLogic.listMots(pairList);

        // Crée un dictionnaire qui relie un mot au bouton portant ce mot
        Dictionary<String, JButton> buttons = new Hashtable<>();

        // Crée les boutons et les associe chacun à un mot différent, leur ajoute un style, les ajoute au dictionnaire et les affiche
        for (int i = 0; i < mots.size(); i++) {
            JButton button = new JButton(mots.get(i));
            MainMenu.addStyleToButton(button);
            buttons.put(mots.get(i), button);
            this.view.getPanel().add(button);
        }

        // Crée un timer de 10ms puis gèle l'écran afin que le joueur puisse regarder les cartes.
        // Gèle l'écran après 10ms pour éviter que l'écran soit vide lorsqu'il est gelé
        new Timer(10, e -> {
            try {
                Thread.sleep(3000);
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
