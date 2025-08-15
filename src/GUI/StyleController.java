package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StyleController {
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

    public static void addStyleToLabel(JLabel label, int size){
        label.setFont(new Font("Serif", Font.BOLD, size));
        label.setBackground(new Color(70,130,180));
        label.setForeground(Color.white);
        label.setOpaque(true);
    }

    public static void addStyleToTextField(JTextField textField, int size){
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(new Color(70,130,180));
        textField.setForeground(Color.white);
        textField.setFont(new Font("Serif", Font.BOLD, size));
    }

    public static void centerApplication(JFrame frame){
        // Obtenir la taille de l'écran en tant que dimension Java
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculer l'emplacement de la fenêtre
        int x = (screenSize.width - frame.getWidth()) / 4;
        int y = (screenSize.height - frame.getHeight()) / 4;

        // Définir l'emplacement de la fenêtre
        frame.setLocation(x, y);
    }
}
