package GUI;

import javax.swing.*;
import java.awt.*;

public class Choose_GameMode {
    public Choose_GameMode() {
        JFrame frame = new JFrame("A horse game about learning english");
        JPanel panel = new JPanel();

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Images/horse_bg.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());
        backgroundLabel.setSize(1280, 720);
        frame.setContentPane(backgroundLabel);

        backgroundLabel.add(panel);

        panel.setOpaque(false);
        panel.setLayout(new BorderLayout(0, 130));

        JButton GameMode1 = new JButton("Game Mode 1");
        JButton GameMode2 = new JButton("test");
        JButton GameMode3 = new JButton("test");
        JButton GameMode4 = new JButton("test");
        JButton exit = new JButton("Exit");

        MainMenu.addStyleToButton(GameMode1);
        MainMenu.addStyleToButton(GameMode2);
        MainMenu.addStyleToButton(GameMode3);
        MainMenu.addStyleToButton(GameMode4);
        MainMenu.addStyleToButton(exit);

        JPanel buttonsPanel = new JPanel(new GridLayout(2,2, 30, 30));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(GameMode1);
        buttonsPanel.add(GameMode2);
        buttonsPanel.add(GameMode3);
        buttonsPanel.add(GameMode4);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exitPanel.setOpaque(false);
        exitPanel.add(exit);

        panel.add(buttonsPanel, BorderLayout.CENTER);
        panel.add(exitPanel, BorderLayout.SOUTH);

        exit.addActionListener(e -> {System.exit(0);});

        // Obtenir la taille de l'écran en tant que dimension Java
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculer l'emplacement de la fenêtre
        int x = (screenSize.width - frame.getWidth()) / 4;
        int y = (screenSize.height - frame.getHeight()) / 4;

        // Définir l'emplacement de la fenêtre
        frame.setLocation(x, y);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
