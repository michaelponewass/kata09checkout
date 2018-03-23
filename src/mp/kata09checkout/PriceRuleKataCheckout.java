package mp.kata09checkout;

/**
 * Created by michael.ponewass on 22.03.2018.
 */
public class PriceRuleKataCheckout implements PriceRule {
    private int amountForSpecialPrice = 0;
    private double specialPrice = 0;

    public PriceRuleKataCheckout(int amountForSpecialPrice, double specialPrice) {
        this.amountForSpecialPrice = amountForSpecialPrice;
        this.specialPrice = specialPrice;
    }

    @Override
    public double getTotal(int amount, double price) {
        int amountNormalPrice = amount % amountForSpecialPrice;
        double total = (amount - amountNormalPrice) / amountForSpecialPrice * specialPrice;
        total += amountNormalPrice * price;
        return total;
    }
}
