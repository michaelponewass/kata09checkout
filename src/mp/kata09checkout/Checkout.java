package mp.kata09checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by michael.ponewass on 22.03.2018.
 */
public class Checkout {
    private Map<Item, Integer> checkoutItems = new HashMap<>();

    private Map<Item, PriceRule> priceRules;

    public Checkout(Map<Item, PriceRule> priceRules) {
        this.priceRules = priceRules;

    }
    public void scan(Item item) {
        int itemCounter = 0;
        if (checkoutItems.containsKey(item)) {
            itemCounter = checkoutItems.get(item);
        }
        itemCounter++;
        checkoutItems.put(item, itemCounter);
    }

    public double getTotal() {
        double total=0;
        for (Map.Entry<Item, Integer> entry : checkoutItems.entrySet()) {
            if (this.priceRules.containsKey(entry.getKey())) {
                PriceRule rule = this.priceRules.get(entry.getKey());
                entry.getValue().setPriceRule(rule);
            }
            total += entry.getTotal(entry.getValue());
        }
        return total;
    }
}
