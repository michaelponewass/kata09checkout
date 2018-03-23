package mp.kata09checkout;

/**
 * Created by michael.ponewass on 22.03.2018.
 */
public class PriceRuleDefault implements PriceRule {

    public PriceRuleDefault() {
    }

    @Override
    public double getTotal(int amount, double price) {
        return amount * price;
    }
}
