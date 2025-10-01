package GUI;

import Controller.*;
import Logic.EnglishToFrenchLogic;
import Logic.FrenchToEnglishLogic;
import Logic.MemoLogic;
import Logic.RaceLogic;

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
        frame.setResizable(false);

        backgroundLabel.add(panel);

        panel.setOpaque(false);
        panel.setLayout(new BorderLayout(0, 130));

        JButton memo = new JButton("Memo");
        JButton frenchToEnglish = new JButton("French To English");
        JButton englishToFrench = new JButton("English To French");
        JButton race = new JButton("Race");
        JButton back = new JButton("Back");

        StyleController.addStyleToButton(memo);
        StyleController.addStyleToButton(frenchToEnglish);
        StyleController.addStyleToButton(englishToFrench);
        StyleController.addStyleToButton(race);
        StyleController.addStyleToButton(back);

        JPanel buttonsPanel = new JPanel(new GridLayout(2,2, 30, 30));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(memo);
        buttonsPanel.add(frenchToEnglish);
        buttonsPanel.add(englishToFrench);
        buttonsPanel.add(race);

        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        exitPanel.setOpaque(false);
        exitPanel.add(back);

        panel.add(buttonsPanel, BorderLayout.CENTER);
        panel.add(exitPanel, BorderLayout.SOUTH);

        memo.addActionListener(e -> {
            new MemoController(new MemoGUI(), new MemoLogic());
            frame.dispose();
        });
        back.addActionListener(e -> {
            new MainMenu();
            frame.dispose();
        });
        frenchToEnglish.addActionListener(e -> {
            new FrenchToEnglishController(new FrenchToEnglishGUI(), new FrenchToEnglishLogic());
            frame.dispose();
        });
        englishToFrench.addActionListener(e -> {
            new EnglishToFrenchController(new EnglishToFrenchGUI(), new EnglishToFrenchLogic());
            frame.dispose();
        });
        race.addActionListener(e -> {
            new RaceController(new RaceGUI(), new RaceLogic());
            frame.dispose();
        });

        StyleController.centerApplication(frame);

        frame.setMinimumSize(new Dimension(1280,720));
        frame.setMaximumSize(new Dimension(1280,720));
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
