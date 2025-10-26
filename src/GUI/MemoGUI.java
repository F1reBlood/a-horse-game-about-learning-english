package GUI;

import Controller.MemoController;
import Logic.StyleManager;
import Logic.MemoLogic;
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
        StyleManager.centerApplication(frame);
        frame.setSize(1280, 720);
        frame.setResizable(false);
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
        StyleManager.addStyleToLabel(label, 34);

        JButton replay = new JButton("Replay");
        StyleManager.addStyleToButton(replay);
        panel.add(replay);
        replay.addActionListener(e -> {
           new MemoController(new MemoGUI(), new MemoLogic());
           frame.dispose();
        });

        JButton back = new JButton("Back");
        StyleManager.addStyleToButton(back);
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
