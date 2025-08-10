package GUI;

import javax.swing.*;
import java.awt.*;

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
           new GameMode1();
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
