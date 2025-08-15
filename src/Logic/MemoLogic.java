package Logic;

import javax.swing.*;
import java.util.*;

public class MemoLogic {

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
}
