package Controller;

import GUI.MemoGUI;
import Logic.MemoLogic;
import Logic.Pair;

import javax.swing.*;
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

        for (int i = 0; i < pairList.size()*2; i++) {
            JButton button = new JButton(mots.get(i));
            this.view.getPanel().add(button);
        }
    }
}
