package GUI;

import Controller.StyleController;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public MainMenu() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Assets/horse_bg.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());
        backgroundLabel.setSize(1280, 720);
        frame.setContentPane(backgroundLabel);

        backgroundLabel.add(panel);

        panel.setOpaque(false);
        panel.setLayout(new GridLayout(4,1, 0, 30));

        JButton play = new JButton("Play");
        JButton character = new JButton("Character");
        JButton settings = new JButton("Settings");
        JButton exit = new JButton("Exit");

        StyleController.addStyleToButton(play);
        StyleController.addStyleToButton(character);
        StyleController.addStyleToButton(settings);
        StyleController.addStyleToButton(exit);

        panel.add(play);
        panel.add(character);
        panel.add(settings);
        panel.add(exit);
        play.addActionListener(e -> {
            new Choose_GameMode();
            frame.dispose();
        });
        exit.addActionListener(e -> System.exit(0));

        StyleController.centerApplication(frame);

        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("A horse game about learning english");
        frame.pack();
        frame.setVisible(true);

    }

}

