package GUI;

import Controller.MemoController;
import Logic.MemoLogic;
import Logic.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Choose_GameMode {
    public Choose_GameMode() {
        JFrame frame = new JFrame("Choose a Game Mode");
        JPanel panel = new JPanel();

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Assets/horse_bg.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());
        backgroundLabel.setSize(1280, 720);
        frame.setContentPane(backgroundLabel);

        backgroundLabel.add(panel);

        panel.setOpaque(false);
        panel.setLayout(new BorderLayout(0, 130));

        JButton memo = new JButton("Memo");
        JButton GameMode2 = new JButton("test");
        JButton GameMode3 = new JButton("test");
        JButton GameMode4 = new JButton("test");
        JButton exit = new JButton("Exit");

        MainMenu.addStyleToButton(memo);
        MainMenu.addStyleToButton(GameMode2);
        MainMenu.addStyleToButton(GameMode3);
        MainMenu.addStyleToButton(GameMode4);
        MainMenu.addStyleToButton(exit);

        JPanel buttonsPanel = new JPanel(new GridLayout(2,2, 30, 30));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(memo);
        buttonsPanel.add(GameMode2);
        buttonsPanel.add(GameMode3);
        buttonsPanel.add(GameMode4);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exitPanel.setOpaque(false);
        exitPanel.add(exit);

        panel.add(buttonsPanel, BorderLayout.CENTER);
        panel.add(exitPanel, BorderLayout.SOUTH);

        memo.addActionListener(e -> {
            List<Pair> pairList = Arrays.asList(
                    new Pair("chat", "cat"),
                    new Pair("chien", "dog"),
                    new Pair("maison", "house"),
                    new Pair("école", "school"),
                    new Pair("livre", "book"),
                    new Pair("stylo", "pen"),
                    new Pair("pomme", "apple"),
                    new Pair("eau", "water"),
                    new Pair("soleil", "sun"),
                    new Pair("lune", "moon")
            );
            new MemoController(new MemoGUI(), new MemoLogic(), pairList);
            frame.dispose();
        });
        exit.addActionListener(e -> {System.exit(0);});

        MainMenu.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
