package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnglishToFrenchLogic {
    // Ne prend que les phrases en anglais, les mets dans une liste et les mélanges
    public static List<String> shuffleEnglishPairs(List<Pair> listPair){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < listPair.size(); i++){
            result.add(listPair.get(i).tradEn);
        }
        Collections.shuffle(result);
        return result;
    }
}
