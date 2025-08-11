package Logic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class MemoLogic {
    // Compare les 2 cartes, si l'une est la traduction de l'autre, alors isPaired = true
    public static boolean isPaired(String trad1, String trad2, Pair[] pairList){
        for (int i = 0; i < pairList.length; i++){
            if ((pairList[i].tradFr == trad1 && pairList[i].tradEn == trad2) || (pairList[i].tradFr == trad2 && pairList[i].tradEn == trad1)){
                return true;
            }
        }
        return false;
    }

    // Récupère tous les mots des Paires et les mélange puis les met dans une liste
    public static List<String> listMots(List<Pair> listPair){
        List<String> result = new ArrayList<>();

        for (int i = 0; i < listPair.size(); i++){
            result.add(listPair.get(i).tradFr);
            result.add(listPair.get(i).tradEn);
        }

        Collections.shuffle(result);
        return result;
    }

    public static void showAllButtons(Hashtable<String, JButton> buttons){
        buttons.forEach((mot, button) ->{
            button.setText(mot);
        });
    }

    public static void hideAllButtons(Hashtable<String, JButton> buttons){
        for (JButton button : buttons.values()){
            button.setText("");
        }
    }


    public static void showOneButton(Hashtable<String, JButton> buttons, JButton buttonToShow){
        buttons.forEach((mot, button) ->{
            if (button.equals(buttonToShow)){
                button.setText(mot);
            }
        });
    }

    public static void hideOneButton(JButton buttonToHide){
        buttonToHide.setText("");
    }
}
