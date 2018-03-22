package mp.kata09checkout;

/**
 * Created by michael.ponewass on 22.03.2018.
 */
public class Item {
    private String sku;
    private double price;
    private PriceRule priceRule;

    public Item(String sku, double price) {
        this.sku = sku;
        this.price = price;
    }
}
