package befaster.solutions.CHK;

import java.util.Map;
import java.util.HashMap;

public class CheckoutSolution {
    private Map<Character, Integer> skuToValue = new HashMap<Character, Integer>() {
        {
            put('A', 50);
            put('B', 30);
            put('C', 20);
            put('D', 15);
        }
    };

    private Map<Character, Map<Integer, Integer>> skuOffers = new HashMap<Character, Map<Integer, Integer>>() {
        {
            Map<Integer, Integer> offerA = new HashMap<Integer, Integer>();
            offerA.put(3, 130);
            Map<Integer, Integer> offerB = new HashMap<Integer, Integer>();
            offerB.put(2, 45);
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
                total -= skuToValue.get(sku) * matchedMinimum;
                total += skuOffers.get(sku).get(matchedMinimum);
            }
        }
        return total;
    }
}



