package GUI;

import javax.swing.*;
import java.awt.*;

public class RaceGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel textToCopy;
    private JLabel enemyText;
    private JTextField userInput;

    public RaceGUI(){
        frame = new JFrame("English to French");
        panel = new JPanel();

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StyleController.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setVisible(true);

        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        textToCopy = new JLabel();
        textToCopy.setHorizontalAlignment(JLabel.CENTER);
        StyleController.addStyleToLabel(textToCopy, 34);

        enemyText = new JLabel();
        StyleController.addStyleToLabel(enemyText, 24);

        userInput = new JTextField();
        StyleController.addStyleToTextField(userInput, 24);

        panel.add(textToCopy);
        panel.add(enemyText);
        panel.add(userInput);
    }

    public void setTextToLabel(JLabel label, String text) {
        label.setText(text);
    }

    public String getUserInput() {
        return userInput.getText();
    }
}
