package Controller;

import GUI.RaceGUI;
import Logic.Player;
import Logic.RaceLogic;
import Logic.TrackPanel;

import javax.swing.*;
import javax.swing.text.StyledDocument;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceController {
    private RaceGUI view;
    private RaceLogic playerModel;
    private RaceLogic enemyModel;
    private Player player;
    private Player enemy;
    private TrackPanel playerPanel;
    private TrackPanel enemyPanel;
    private JTextPane userTextPane;
    private String userInput;
    private String currentPhrase;

    public RaceController(RaceGUI view, RaceLogic model) throws IOException {
        this.view = view;
        playerModel = model;
        enemyModel = new RaceLogic();

        playerPanel = (TrackPanel) view.getUserTrackPanel();
        enemyPanel = (TrackPanel) view.getEnemyTrackPanel();

        player = new Player("horse1");
        enemy = new Player("horse8");


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
        Collections.shuffle(listPhrases);

        currentPhrase = listPhrases.get(0);
        view.getTextToCopy().setText(currentPhrase);

        // Joueur : idleHorse au start; vérification à chaque espace, quand le mot est bon : animateFrame; sinon : la lettre qui n'est pas bonne on la met en rouge
        // Enemy : on met un timer (plus ou moins long en fonction de la difficulté) et à chaque tour de timer, il y a une chance (fixe ou qui bouge en fonction du nombre de mot du joueur jsp) que le bot avance

        playerModel.idleHorse(playerPanel, player);
        enemyModel.idleHorse(enemyPanel, enemy);

        StyledDocument doc = userTextPane.getStyledDocument();

        // à chaque fois que le joueur appuie sur espace, on récupère son input
        view.getUserTextPane().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    userInput = view.getUserInput();

                    // Itère sur chaque charcatère de ce que le joueur écrit
                    for (int i=0; i<userInput.length(); i++){
                        char c = userInput.charAt(i);
                        char c2 = currentPhrase.charAt(i);

                        if (c != c2){
                            // On affiche la lettre en rouge

                        }
                    }
                }
            }
        });
    }
}
