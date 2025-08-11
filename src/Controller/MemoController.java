package Controller;

import GUI.MainMenu;
import GUI.MemoGUI;
import Logic.MemoLogic;
import Logic.Pair;

import javax.swing.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class MemoController {
    private MemoGUI view;
    private MemoLogic model;
    private List<Pair> pairList;

    public MemoController(MemoGUI view, MemoLogic model, List<Pair> pairList){
        this.view = view;
        this.model = model;
        this.pairList = pairList;

        List<String> mots = MemoLogic.listMots(pairList);

        Dictionary<String, JButton> buttons = new Hashtable<>();

        for (int i = 0; i < mots.size(); i++) {
            JButton button = new JButton(mots.get(i));
            MainMenu.addStyleToButton(button);
            buttons.put(mots.get(i), button);
            this.view.getPanel().add(button);
        }
    }
}
