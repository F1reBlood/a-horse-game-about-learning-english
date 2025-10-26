package GUI;

import Logic.StyleManager;
import Logic.TrackPanel;

import javax.swing.*;
import java.awt.*;

public class RaceGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel textToCopy;
    private JTextPane userInput;
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
        StyleManager.centerApplication(frame);
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
        StyleManager.addStyleToLabel(textToCopy, 34);

        userInput = new JTextPane();
        StyleManager.addStyleToTextPane(userInput, 24);

        mainPanel.add(textToCopy);
        mainPanel.add(userInput);


    }

    public void setTextToCopy(String text){
        textToCopy.setText(text);
    }
    public JLabel getTextToCopy(){
        return textToCopy;
    }
    public String getUserInput() {
        return userInput.getText();
    }
    public JTextPane getUserTextPane() {
        return userInput;
    }
    public JPanel getUserTrackPanel() {
        return userTrackPanel;
    }
    public JPanel getEnemyTrackPanel() {
        return enemyTrackPanel;
    }
}
