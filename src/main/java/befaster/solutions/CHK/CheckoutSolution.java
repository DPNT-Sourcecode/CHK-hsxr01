package befaster.solutions.CHK;

import java.util.Map;
import java.util.HashMap;
import java.lang.Math;
import javafx.util.Pair;

public class CheckoutSolution {
    private Map<Character, Integer> skuToValue = new HashMap<Character, Integer>() {
        {
            put('A', 50);
            put('B', 30);
            put('C', 20);
            put('D', 15);
            put('E', 40);
        }
    };

    /**
     * map off key to offer
     * the value pair represents the discount to be applied and the free items to be given in the form of a map where
     * the key is the sku and the value is the number of items to give for free
     */
    private Map<Character, Map<Integer, Pair<Integer, Map<Character, Integer>>>> skuOffers = new HashMap<Character, Map<Integer, Pair<Integer, Map<Character, Integer>>>>() {
        {
            Map<Integer, Pair<Integer, Map<Character, Integer>>> offerA = new HashMap<Integer, Pair<Integer, Map<Character, Integer>>>();
            offerA.put(3, new Pair<Integer, Map<Character, Integer>>(130, new HashMap<Character, Integer>()));
            offerA.put(5, new Pair<Integer, Map<Character, Integer>>(200, new HashMap<Character, Integer>()));
            Map<Integer, Pair<Integer, Map<Character, Integer>>> offerB = new HashMap<Integer, Pair<Integer, Map<Character, Integer>>>();
            offerB.put(2, new Pair<Integer, Map<Character, Integer>>(45, new HashMap<Character, Integer>()));
            Map<Integer, Pair<Integer, Map<Character, Integer>>> offerE = new HashMap<Integer, Pair<Integer, Map<Character, Integer>>>();
            offerB.put(2, new Pair<Integer, Map<Character, Integer>>(0, new HashMap<Character, Integer>() {
                {
                    put('B', 1);
                }
            }));
            put('A', offerA);
            put('B', offerB);
        }
    };


    public Integer checkout(String skus) {
        Integer total = 0;
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        for (char sku: skus.toCharArray()) {
            if (!skuToValue.containsKey(sku)) {
                return -1;
            }
            total += skuToValue.get(sku);
            found.put(sku, found.containsKey(sku) ? found.get(sku) + 1 : 1);
        }
        for(Map.Entry<Character, Integer> entry : found.entrySet()) {
            Character sku = entry.getKey();
            if (!skuOffers.containsKey(sku)) {continue;}
            Integer numberFound = entry.getValue();
            Integer matchedMinimum = 0;
            for(Map.Entry<Integer, Integer> offerEntry : skuOffers.get(sku).entrySet()) {
                Integer minimum = offerEntry.getKey();
                if (minimum > numberFound) {continue;}
                if (minimum == numberFound) {
                    matchedMinimum = minimum;
                    break;
                }
                if (matchedMinimum < minimum) {
                    matchedMinimum = minimum;
                }
            }
            if (matchedMinimum > 0) {
                Integer offersToApply = Math.floorDiv(numberFound, matchedMinimum);
                total -= skuToValue.get(sku) * matchedMinimum * offersToApply;
                total += skuOffers.get(sku).get(matchedMinimum) * offersToApply;
            }
        }
        return total;
    }
}

