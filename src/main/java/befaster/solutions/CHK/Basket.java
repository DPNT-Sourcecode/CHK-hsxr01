package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    Map<Character, Integer> items = new HashMap<Character, Integer>();

    void add(Character sku) {
        if (items.containsKey(sku)) {
            items.put(sku, items.get(sku) + 1);
        } else {
            items.put(sku, items.get(sku) + 1);
        }
    }
}

