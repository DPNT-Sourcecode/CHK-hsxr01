package befaster.solutions.CHK;

public class CheckoutSolution {
    private Map<char, Integer> skuToValue = new HashMap<char, Integer>() {
        {
            put('A', 50);
            put('B', 30);
            put('C', 20);
            put('D', 15);
        }
    };

    public Integer checkout(String skus) {
        Integer total = 0;
        for (char sku: skus.toCharArray()) {
            if (!skuToValue.containsKey(sku)) {
                return -1;
            }
        }
        return total;
    }
}



