package Logic;

import javax.swing.*;
import java.util.*;

public class GameLogic {

    // Compare les 2 chaines de charactères, si l'une est la traduction de l'autre, alors isPaired = true
    public static boolean isPaired(String trad1, String trad2, List<Pair> pairList){
        for (int i = 0; i < pairList.size(); i++){
            if ((pairList.get(i).tradFr.equals(trad1) && pairList.get(i).tradEn.equals(trad2)) || (pairList.get(i).tradFr.equals(trad2) && pairList.get(i).tradEn.equals(trad1))){
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

    // Si toutes les paires ont été trouvées, retourne true, sinon retourne false
    public static boolean isEveryPairsFound(Hashtable<String, JButton> buttons){
        for (JButton button : buttons.values()){
            if (button.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }

    // Ne prend que les phrases en anglais, les mets dans une liste et les mélanges
    public static List<String> shuffleEnglishPairs(List<Pair> listPair){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listPair.size(); i++){
            result.add(listPair.get(i).tradEn);
        }
        Collections.shuffle(result);
        return result;
    }

    // Ne prend que les phrases en français, les mets dans une liste et les mélanges
    public static List<String> shuffleFrenchPairs(List<Pair> listPair){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listPair.size(); i++){
            result.add(listPair.get(i).tradFr);
        }
        Collections.shuffle(result);
        return result;
    }
}
