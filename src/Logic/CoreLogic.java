package Logic;

import java.util.List;

public class CoreLogic {
    // Compare les 2 chaines de charactères, si l'une est la traduction de l'autre, alors isPaired = true
    public static boolean isPaired(String trad1, String trad2, List<Pair> pairList){
        for (int i = 0; i < pairList.size(); i++){
            if ((pairList.get(i).tradFr.equals(trad1) && pairList.get(i).tradEn.equals(trad2)) || (pairList.get(i).tradFr.equals(trad2) && pairList.get(i).tradEn.equals(trad1))){
                return true;
            }
        }
        return false;
    }
}
