package Logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TrackPanel extends JPanel {
    private int posX;
    private int posY;
    private BufferedImage frame;
    private BufferedImage grassTexture;
    {
        try {
            grassTexture = ImageIO.read(getClass().getResource("/Assets/grassTexture.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFrame(int posX, int posY, BufferedImage frame){
        this.posX = posX;
        this.posY = posY;
        this.frame = frame;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessine le fond (en répétant la texture)
        for (int x = 0; x < getWidth(); x += grassTexture.getWidth()) {
            for (int y = 0; y < getHeight(); y += grassTexture.getHeight()) {
                g.drawImage(grassTexture, x, y, this);
            }
        }

        // Dessin
        if (frame != null) {
            g.drawImage(frame, posX, posY, 128, 96, null);
        }
    }
}
