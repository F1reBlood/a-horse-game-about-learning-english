package GUI;

import javax.swing.*;
import java.awt.*;

public class GameMode1 {
    public GameMode1(){
        JFrame frame = new JFrame("Memo");
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout());
        frame.add(panel);
        MainMenu.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
