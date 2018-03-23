package mp.kata09checkout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael.ponewass on 22.03.2018.
 */
public class Checkout {
    /* store for checkout items */
    private Map<Item, Integer> checkoutItems;
    /* price rule holder */
    private Map<Item, PriceRule> priceRules;

    public Checkout(Map<Item, PriceRule> priceRules) {
        this.priceRules = priceRules;
        this.checkoutItems = new HashMap<>();

    }

    /**
     * store the items for checkout
     *
     * @param item the item to calculate
     */
    public void scan(Item item) {
        int itemCounter = 0;
        if (checkoutItems.containsKey(item)) {
            itemCounter = checkoutItems.get(item);
        }
        itemCounter++;
        checkoutItems.put(item, itemCounter);
    }

    /**
     * Calculates the total price of checkout
     *
     * @return total price
     */
    public double getTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : checkoutItems.entrySet()) {
            Item item = entry.getKey();
            int amount = entry.getValue();
            PriceRule rule = this.priceRules.get(item);
            if (rule == null) {
                rule = new PriceRuleDefault();
            }
            total += rule.getTotal(amount, item.getPrice());
        }
        return total;
    }
}
