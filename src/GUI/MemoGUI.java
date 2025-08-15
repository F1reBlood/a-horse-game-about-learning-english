package GUI;

import Controller.MemoController;
import Logic.GameLogic;
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
        frame.setVisible(true);

    }

    public void endMemo(List<Pair> pairList, int score){
        panel.removeAll();
        JLabel label;

        if (score>0){
            label = new JLabel("Bravo, tu as gagné ! Ton score est de : " + score, SwingConstants.CENTER);
        }
        else{
            label = new JLabel("Dommage, tu as perdu ! Ton score est de : " + score, SwingConstants.CENTER);
        }
        label.setLayout(new GridLayout(3, 1, 50, 50));
        panel.add(label);
        label.setFont(new Font("Serif", Font.BOLD, 34));
        label.setBackground(new Color(70,130,180));
        label.setForeground(Color.white);
        label.setOpaque(true);

        JButton replay = new JButton("Replay");
        MainMenu.addStyleToButton(replay);
        panel.add(replay);
        replay.addActionListener(e -> {
           new MemoController(new MemoGUI(), new GameLogic(), pairList);
           frame.dispose();
        });

        JButton back = new JButton("Back");
        MainMenu.addStyleToButton(back);
        back.addActionListener(e -> {
            new Choose_GameMode();
            frame.dispose();
        });
        panel.add(back);
        panel.repaint();

    }

    public JFrame getFrame(){
        return frame;
    }
    public JPanel getPanel(){
        return panel;
    }
}
