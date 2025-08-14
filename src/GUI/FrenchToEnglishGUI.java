package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FrenchToEnglishGUI {
    public FrenchToEnglishGUI() {
        JFrame frame = new JFrame("French to English");
        JPanel panel = new JPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setVisible(true);

        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel textToTranslate = new JLabel("This is a test sentence, and it's cool !");
        textToTranslate.setHorizontalAlignment(JLabel.CENTER);
        MainMenu.addStyleToLabel(textToTranslate, 34);

        JTextField userText = new JTextField();
        MainMenu.addStyleToTextField(userText, 24);

        JButton submit = new JButton("Submit");
        MainMenu.addStyleToButton(submit);

        panel.add(textToTranslate);
        panel.add(userText);
        panel.add(submit);
    }
}
