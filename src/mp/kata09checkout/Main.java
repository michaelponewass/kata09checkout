package mp.kata09checkout;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Item ia = new Item("A", 50);
        Item ib = new Item("B", 30);
        Item ic = new Item("C", 20);
        Item id = new Item("D", 15);

        Map priceRules = new HashMap<Item, PriceRule>();
        priceRules.put(ia, new PriceRule(3, 130));
        priceRules.put(ib, new PriceRule(2, 45));


        System.out.println("test totals ---------------------");

        Checkout coStep = new Checkout(priceRules);
        TestRunner.test(coStep, "no item",0);

        coStep.scan(ia);
        TestRunner.test(coStep, "item A",50);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ib);
        TestRunner.test(coStep, "item AB",80);

        coStep = new Checkout(priceRules);
        coStep.scan(ic);
        coStep.scan(id);
        coStep.scan(ib);
        coStep.scan(ia);
        TestRunner.test(coStep, "item CDBA",115);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AA",100);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AAA",130);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AAAA",180);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AAAAA",230);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AAAAAA",260);


        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ib);
        TestRunner.test(coStep, "item AAAB",160);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AA",100);

        coStep = new Checkout(priceRules);
        coStep.scan(ia);
        coStep.scan(ia);
        TestRunner.test(coStep, "item AA",100);

        /*
        def test_totals
        assert_equal(  0, price(""))
        assert_equal( 50, price("A"))
        assert_equal( 80, price("AB"))
        assert_equal(115, price("CDBA"))
        assert_equal(100, price("AA"))
        assert_equal(130, price("AAA"))
        assert_equal(180, price("AAAA"))
        assert_equal(230, price("AAAAA"))
        assert_equal(260, price("AAAAAA"))
        assert_equal(160, price("AAAB"))
        assert_equal(175, price("AAABB"))
        assert_equal(190, price("AAABBD"))
        assert_equal(190, price("DABABA"))
        end

        def test_incremental
        co = CheckOut.new(RULES)
                assert_equal(  0, co.total)
        co.scan("A");  assert_equal( 50, co.total)
        co.scan("B");  assert_equal( 80, co.total)
        co.scan("A");  assert_equal(130, co.total)
        co.scan("A");  assert_equal(160, co.total)
        co.scan("B");  assert_equal(175, co.total)
        end




        System.out..println("coStep.getTotal()



        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);
        coStep.scan(ia);

        double total = coStep.getTotal();
        System.out.println("total: " + total);

*/
    }

    private static class TestRunner {
        public static void test(Checkout coStep, String testText, double totalPrice) {
            if (coStep.getTotal() == totalPrice) {
                System.out.println("test passed, "+testText + " for " + totalPrice);
            } else {
                System.out.println("test failed, "+testText + " for " + totalPrice);
            }
        }
    }
}
