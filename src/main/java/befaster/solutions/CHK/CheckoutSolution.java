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
        for (char sku: skus.toCharArray()) {
            if (!skuToValue.containsKey(sku)) {
                return -1;
            }
            total += skuToValue.get(sku);
        }
        return total;
    }
}
