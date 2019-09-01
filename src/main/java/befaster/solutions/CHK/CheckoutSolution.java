package befaster.solutions.CHK;

public class CheckoutSolution {
    private Map<String, Integer> skus = new HashMap<String, Integer>() {
        {
            put("A", 50);
            put("B", 30);
            put("C", 20);
            put("D", 15);
        }
    };

    public Integer checkout(String skus) {
        if (skus == "") {
            return 0;
        }
        
        return -1;
    }
}


