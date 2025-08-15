package Logic;

import javax.swing.*;
import java.util.*;

public class GameLogic {
    private int score = 100;

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

    // Affiche le mot (key) du dictionnaire buttons sur le bouton associé (fait ça pour tous les boutons du dictionnaire)
    public static void showAllButtons(Hashtable<String, JButton> buttons){
        buttons.forEach((mot, button) ->{
            button.setText(mot);
        });
    }

    // Supprime le texte (cache) sur tous les boutons du dictionnaire buttons (fait ça pour tous les boutons du dictionnaire)
    public static void hideAllButtons(Hashtable<String, JButton> buttons){
        for (JButton button : buttons.values()){
            button.setText("");
        }
    }

    // Affiche le mot (key) du dictionnaire buttons sur le bouton associé (fait ça seulement pour le buttonToShow)
    public static void showOneButton(Hashtable<String, JButton> buttons, JButton buttonToShow){
        buttons.forEach((mot, button) ->{
            if (button.equals(buttonToShow)){
                button.setText(mot);
            }
        });
    }

    // Supprime le texte (cache) sur tous les boutons du dictionnaire buttons (fait ça uniquement pour le buttonToHide)
    public static void hideOneButton(JButton buttonToHide){
        buttonToHide.setText("");
    }

    public void removeScore(int nbToRemove){
        score -= nbToRemove;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
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
