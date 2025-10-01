package GUI;

import Controller.StyleController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class TrackPanel extends JPanel{
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

    void setFrame(int posX, int posY, BufferedImage frame){
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

public class RaceGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel textToCopy;
    private JTextField userInput;
    private JPanel userTrackPanel;
    private JPanel enemyTrackPanel;

    /*
    Sprites :
    48 pixels = hauteur d'une image
    64 pixels = largeur d'une image
    */

    public RaceGUI(){
        frame = new JFrame("Race");
        mainPanel = new JPanel();

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StyleController.centerApplication(frame);
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setVisible(true);

        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        userTrackPanel = new TrackPanel();
        mainPanel.add(userTrackPanel);


        enemyTrackPanel = new TrackPanel();
        mainPanel.add(enemyTrackPanel);

        textToCopy = new JLabel();
        textToCopy.setHorizontalAlignment(JLabel.CENTER);
        StyleController.addStyleToLabel(textToCopy, 34);

        userInput = new JTextField();
        StyleController.addStyleToTextField(userInput, 24);

        mainPanel.add(textToCopy);
        mainPanel.add(userInput);




        /*
        Tests :

        private BufferedImage horseImage;
        private BufferedImage frame1;

        try{
            horseImage = ImageIO.read(getClass().getResource("/Assets/Horses/horse1.png"));
        } catch(Exception e){
            e.printStackTrace();
        }

        frame1 = horseImage.getSubimage(0, 0, 64, 48);

        ((TrackPanel) userTrackPanel).setFrame(0, 0, frame1);
        ((TrackPanel) enemyTrackPanel).setFrame(0, 0, frame1);

        */
    }

    public void setTextToCopy(String text){
        textToCopy.setText(text);
    }
    public String getTextToCopy(){
        return textToCopy.getText();
    }
    public String getUserInput() {
        return userInput.getText();
    }
}
