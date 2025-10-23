package Controller;

import GUI.RaceGUI;
import Logic.Player;
import Logic.RaceLogic;
import Logic.TrackPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceController {
    private RaceGUI view;
    private RaceLogic model;
    private Player player;
    private Player enemy;
    private TrackPanel playerPanel;
    private TrackPanel enemyPanel;

    public RaceController(RaceGUI view, RaceLogic model) throws IOException {
        this.view = view;
        this.model = model;

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

        // Joueur : idleHorse au start; vérification à chaque espace, quand le mot est bon : animateFrame; sinon : la lettre qui n'est pas bonne on la met en rouge
        // Enemy : on met un timer (plus ou moins long en fonction de la difficulté) et à chaque tour de timer, il y a une chance (fixe ou qui bouge en fonction du nombre de mot du joueur jsp) que le bot avance

        // à debug, quand il y a les 2 animations en même temps, la frame du milieu ne se joue pas, et l'animation du 2e Player se joue une seule fois
        model.idleHorse(playerPanel, player);
        //model.idleHorse(enemyPanel, enemy);

    }
}
