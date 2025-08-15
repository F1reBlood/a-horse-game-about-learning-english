package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrenchToEnglishLogic {
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
