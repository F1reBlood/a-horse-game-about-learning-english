package GUI;

import Controller.FrenchToEnglishController;
import Controller.StyleController;
import Logic.FrenchToEnglishLogic;

import javax.swing.*;
import java.awt.*;

public class FrenchToEnglishGUI {
    private JButton submit;
    private JLabel textToTranslate;
    private JTextField userText;
    private JFrame frame;
    private JPanel panel;

    public FrenchToEnglishGUI() {
        frame = new JFrame("French to English");
        panel = new JPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StyleController.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setVisible(true);

        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        textToTranslate = new JLabel("This is a test sentence, and it's cool !");
        textToTranslate.setHorizontalAlignment(JLabel.CENTER);
        StyleController.addStyleToLabel(textToTranslate, 34);

        userText = new JTextField();
        StyleController.addStyleToTextField(userText, 24);

        submit = new JButton("Submit");
        StyleController.addStyleToButton(submit);

        panel.add(textToTranslate);
        panel.add(userText);
        panel.add(submit);
    }

    public JButton getSubmitButton(){
        return submit;
    }
    public JLabel getTextToTranslateLabel(){
        return textToTranslate;
    }
    public JTextField getUserTextField(){
        return userText;
    }

    public void endFrenchToEnglish(int score, int nbTours){
        panel.removeAll();
        JLabel label;

        if (score>(nbTours/2)){
            label = new JLabel("Bravo, tu as gagné ! Ton score est de : " + score, SwingConstants.CENTER);
        }
        else{
            label = new JLabel("Dommage, tu as perdu ! Ton score est de : " + score, SwingConstants.CENTER);
        }
        label.setLayout(new GridLayout(3, 1, 50, 50));
        panel.add(label);
        StyleController.addStyleToLabel(label, 34);

        JButton replay = new JButton("Replay");
        StyleController.addStyleToButton(replay);
        panel.add(replay);
        replay.addActionListener(e -> {
            new FrenchToEnglishController(new FrenchToEnglishGUI(), new FrenchToEnglishLogic());
            frame.dispose();
        });

        JButton back = new JButton("Back");
        StyleController.addStyleToButton(back);
        back.addActionListener(e -> {
            new Choose_GameMode();
            frame.dispose();
        });
        panel.add(back);
        panel.repaint();
    }
}
