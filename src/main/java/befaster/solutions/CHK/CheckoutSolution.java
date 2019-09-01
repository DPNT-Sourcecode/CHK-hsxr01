package befaster.solutions.CHK;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
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
    private Map<Character, List<Pair<Integer, Pair<Integer, Map<Character, Integer>>>>> skuOffers = new HashMap<Character, List<Pair<Integer, Pair<Integer, Map<Character, Integer>>>>>() {
        {
            put('A', new LinkedList<Pair<Integer, Pair<Integer, Map<Character, Integer>>>>() {
                {
                    add(new Pair<Integer, Pair<Integer, Map<Character, Integer>>>(3, new Pair<>(130, new HashMap<>())));
                    add(new Pair<Integer, Pair<Integer, Map<Character, Integer>>>(5, new Pair<>(200, new HashMap<>())));
                }
            });
            put('B', new LinkedList<Pair<Integer, Pair<Integer, Map<Character, Integer>>>>() {
                {
                    add(new Pair<Integer, Pair<Integer, Map<Character, Integer>>>(2, new Pair<>(45, new HashMap<>())));
                }
            });
            put('E', new LinkedList<Pair<Integer, Pair<Integer, Map<Character, Integer>>>>() {
                {
                    add(new Pair<Integer, Pair<Integer, Map<Character, Integer>>>(2, new Pair<>(0, new HashMap<Character, Integer>() {
                        {
                            put('B', 1);
                        }
                    })));
                }
            });
        }
    };


    public Integer checkout(String skus) {
        Integer total = 0;
        Map<Character, Integer> found = new HashMap<Character, Integer>();
        // first we will count the items found
        for (char sku: skus.toCharArray()) {
            if (!skuToValue.containsKey(sku)) {
                return -1;
            }
            found.put(sku, found.containsKey(sku) ? found.get(sku) + 1 : 1);
        }
        // now we will see if we should have any free items and remove them from the count
        for(Map.Entry<Character, Integer> skuEntry : found.entrySet()) {
            Character sku = skuEntry.getKey();
            if (!skuOffers.containsKey(sku)) {continue;}
            Integer numberFound = skuEntry.getValue();
            while (skuOffers.get(sku))
        }
        return total;
    }
}
