package GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public MainMenu() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0, 1));

        // Obtenir la taille de l'écran en tant que dimension Java
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculer l'emplacement de la fenêtre
        int x = (screenSize.width - frame.getWidth()) / 4;
        int y = (screenSize.height - frame.getHeight()) / 4;

        // Définir l'emplacement de la fenêtre
        frame.setLocation(x, y);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.add(panel);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("A horse game about learning english");
        frame.pack();
        frame.setVisible(true);
        //Ceci est un test
        frame.setVisible(false);
    }

}

