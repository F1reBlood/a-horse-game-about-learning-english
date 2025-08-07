package GUI;

import com.sun.jdi.event.MethodExitEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu {
    public static void addStyleToButton(JButton button){
        button.setBackground(new Color(70,130,180));
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(75,153,212));
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(70,130,180));
            }
        });
    }

    public MainMenu() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/Images/horse_bg.jpg"));
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

        addStyleToButton(play);
        addStyleToButton(character);
        addStyleToButton(settings);
        addStyleToButton(exit);

        panel.add(play);
        panel.add(character);
        panel.add(settings);
        panel.add(exit);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Choose_GameMode();
                frame.dispose();
            }
        });
        exit.addActionListener(e -> System.exit(0));

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
        frame.setTitle("A horse game about learning english");
        frame.pack();
        frame.setVisible(true);

    }

}

