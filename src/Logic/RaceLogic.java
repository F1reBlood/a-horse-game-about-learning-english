package Logic;

import GUI.TrackPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class RaceLogic {
    private int heightPx = 48;
    private int widthPx = 64;
    private BufferedImage horseImage;
    private BufferedImage normalFrame;
    private BufferedImage runningFrame;
    private Timer idleTimer;
    private boolean reverse;

    private int y = 0;

    public RaceLogic() {

    }

    public void idleHorse(JPanel panel, int posX, int posY) throws IOException {
        BufferedImage frame1, frame2, frame3;
        reverse = false;

        // Panel = EnemyPanel or PlayerPanel
        horseImage = ImageIO.read(getClass().getResource("/Assets/Horses/horse1.png"));
        frame1 = horseImage.getSubimage(widthPx * 0, heightPx, widthPx, heightPx);
        frame2 = horseImage.getSubimage(widthPx * 1, heightPx, widthPx, heightPx);
        frame3 = horseImage.getSubimage(widthPx * 2, heightPx, widthPx, heightPx);

        ArrayList<BufferedImage> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);

        ((TrackPanel) panel).setFrame(0, 0, frame1);

        idleTimer = new Timer(200, e -> {
            ((TrackPanel) panel).setFrame(posX, posY, frames.get(y));
            if (y < 2 && reverse == false){
                y += 1;
            } else if (y >= 2 && reverse == false) {
                y -= 1;
                reverse = true;
            } else if (y > 0 && reverse == true) {
                y -= 1;
            }
            else{
                y += 1;
                reverse = false;
            }


        });
        idleTimer.start();
    }

    public void animateFrame(JPanel panel, int i) throws IOException {
        // i = nombre de frame parcourue
        idleTimer.stop();
    }
}
