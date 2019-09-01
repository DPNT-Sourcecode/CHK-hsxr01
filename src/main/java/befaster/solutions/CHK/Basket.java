package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    List<BasketItem> items;
    Map<Character, BasketItem> map = new HashMap<Character, BasketItem>();

    void add(Item item) {
        if (map.containsKey(item.sku)) {
            map.get(item.sku).add();
        }
    }
}
