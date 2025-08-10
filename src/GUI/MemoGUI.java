package GUI;

import Logic.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MemoGUI {
    private JFrame frame;
    private JPanel panel;

    public MemoGUI(){
        frame = new JFrame("Memo");
        panel = new JPanel();

        panel.setLayout(new GridLayout(4, 5, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(panel);
        MainMenu.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


    public JFrame getFrame(){
        return frame;
    }
    public JPanel getPanel(){
        return panel;
    }
}
