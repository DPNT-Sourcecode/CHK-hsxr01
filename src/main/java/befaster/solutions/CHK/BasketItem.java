package befaster.solutions.CHK;

public class BasketItem {
    Item item;
    Integer quantity;

    public BasketItem(Item item) {
        this.item = item;
        quantity = 1;
    }

    public BasketItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    void addAnother() {
        quantity++;
    }
}
