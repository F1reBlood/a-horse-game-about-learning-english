package Logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class RaceLogic {
    private int heightPx = 48;
    private int widthPx = 64;
    private int endRacePx = 1100;
    private BufferedImage horseImage;
    private BufferedImage normalFrame;
    private BufferedImage runningFrame;
    private Timer idleTimer;
    private Timer animateTimer;
    private boolean reverse;

    private int newPos;
    private int cpt;

    public RaceLogic() {

    }

    // Joue l'animation du cheval qui reste sur place
    public void idleHorse(JPanel panel, Player player) throws IOException {
        BufferedImage frame1, frame2, frame3;
        reverse = false;
        if (animateTimer != null) {
            animateTimer.stop();
        }
        cpt = 0;

        // Panel = EnemyPanel or PlayerPanel
        horseImage = ImageIO.read(getClass().getResource("/Assets/Horses/" + player.getHorse() + ".png"));
        frame1 = horseImage.getSubimage(widthPx * 0, heightPx, widthPx, heightPx);
        frame2 = horseImage.getSubimage(widthPx * 1, heightPx, widthPx, heightPx);
        frame3 = horseImage.getSubimage(widthPx * 2, heightPx, widthPx, heightPx);

        ArrayList<BufferedImage> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);

        ((TrackPanel) panel).setFrame(player.getPosX(), player.getPosY(), frame1);

        // Chaque 200 ms, on change la frame pour la suivante afin de faire l'animation. La variable "reverse" sert à savoir quel frame afficher lorsque l'animation se joue à l'envers (retour de la queue).
        idleTimer = new Timer(400, e -> {
            ((TrackPanel) panel).setFrame(player.getPosX(), player.getPosY(), frames.get(cpt));
            if (cpt < 2 && reverse == false){
                cpt += 1;
            } else if (cpt >= 2 && reverse == false) {
                cpt -= 1;
                reverse = true;
            } else if (cpt > 0 && reverse == true) {
                cpt -= 1;
            }
            else{
                cpt += 1;
                reverse = false;
            }
        });
        idleTimer.start();
    }

    // Fais avancer le cheval d'une "case" après avoir écrit un mot correctement + compte automatiquement le nombre de case à avancer en fonction du nombre de mots total
    public void animateFrame(JPanel panel, Player player, int nbOfWords) throws IOException {
        BufferedImage frame1, frame2, frame3, frame4, frame5;
        int pxToAdvance = endRacePx /  nbOfWords;
        int pxToAdvancePerFrame = pxToAdvance / 5;

        if (idleTimer != null) {
            idleTimer.stop();
        }

        horseImage = ImageIO.read(getClass().getResource("/Assets/Horses/" + player.getHorse() + ".png"));
        frame1 = horseImage.getSubimage(widthPx * 0, heightPx * 13, widthPx, heightPx);
        frame2 = horseImage.getSubimage(widthPx * 1, heightPx * 13, widthPx, heightPx);
        frame3 = horseImage.getSubimage(widthPx * 2, heightPx * 13, widthPx, heightPx);
        frame4 = horseImage.getSubimage(widthPx * 3, heightPx * 13, widthPx, heightPx);
        frame5 = horseImage.getSubimage(widthPx * 4, heightPx * 13, widthPx, heightPx);

        ArrayList<BufferedImage> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);
        frames.add(frame4);
        frames.add(frame5);

        animateTimer = new Timer(150, e -> {
            newPos = player.getPosX() + pxToAdvancePerFrame;
            player.setPosX(newPos);
            ((TrackPanel) panel).setFrame(player.getPosX(), player.getPosY(), frames.get(cpt));
            cpt += 1;
            if (cpt == 5){
                animateTimer.stop();
                try {
                    idleHorse(panel, player);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        animateTimer.start();
    }
}
