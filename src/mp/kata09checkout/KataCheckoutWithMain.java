package mp.kata09checkout;

import java.util.HashMap;
import java.util.Map;

public class KataCheckoutWithMain {

    public static void main(String[] args) {

        Item ia = new Item("A", 50);
        Item ib = new Item("B", 30);
        Item ic = new Item("C", 20);
        Item id = new Item("D", 15);

        Map<Item, PriceRule> priceRules = new HashMap<>();
        priceRules.put(ia, new PriceRuleKataCheckout(3, 130));
        priceRules.put(ib, new PriceRuleKataCheckout(2, 45));

        System.out.println("testCheckout totals ---------------------");

        Checkout coStep = new Checkout(priceRules);
        TestRunner.testCheckout(coStep, "no item", 0);

        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item A", 50);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ib);
        TestRunner.testCheckout(coStep, "item AB", 80);

        coStep = new Checkout(priceRules);
        coStep.scan(ic);
        coStep.scan(id);
        coStep.scan(ib);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item CDBA", 115);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item AA", 100);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item AAA", 130);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item AAAA", 180);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item AAAAA", 230);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item AAAAAA", 260);


        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ib);
        TestRunner.testCheckout(coStep, "item AAAB", 160);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ib);
        coStep.scan(ib);
        TestRunner.testCheckout(coStep, "item AAABB", 175);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ib);
        coStep.scan(ib);
        coStep.scan(id);
        TestRunner.testCheckout(coStep, "item AAABBD", 190);

        coStep = new Checkout(priceRules);
        coStep.scan(id);
        coStep.scan(ia);
        coStep.scan(ib);
        coStep.scan(ia);
        coStep.scan(ib);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item DABABA", 190);


        System.out.println("testCheckout incremenentals ---------------------");

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item A", 50);
        coStep.scan(ib);
        TestRunner.testCheckout(coStep, "item AB", 80);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item ABA", 130);
        coStep.scan(ia);
        TestRunner.testCheckout(coStep, "item ABAA", 160);
        coStep.scan(ib);
        TestRunner.testCheckout(coStep, "item ABAAB", 175);

    }

    private static class TestRunner {
        public static void testCheckout(Checkout coStep, String testText, double totalPrice) {
            if (coStep.getTotal() == totalPrice) {
                System.out.println("testCheckout passed, " + testText + " for " + totalPrice);
                return;
            }
            System.out.println("testCheckout failed, " + testText + " for " + totalPrice);
        }
    }
}
