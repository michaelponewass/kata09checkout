package mp.kata09checkout;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map priceRules = new HashMap<Item, PriceRule>();

        Item ia = new Item("A", 50);
        priceRules.put(ia, new PriceRule(3, 130));
        Item ib = new Item("B", 30);
        priceRules.put(ia, new PriceRule(2, 45));
        Item ic = new Item("C", 20);
        Item id = new Item("D", 15);
        Checkout coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        double total = coStep.getTotal();








	// write your code here
    }
}
