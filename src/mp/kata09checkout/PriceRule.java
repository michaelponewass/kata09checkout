package mp.kata09checkout;

/**
 * Created by michael.ponewass on 22.03.2018.
 */
public class PriceRule {
    private final int amount;
    private final double specialPrice;

    public PriceRule(int amount, double specialPrice) {
        this.amount=amount;
        this.specialPrice = specialPrice;
    }

    public int getAmount() {
        return amount;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }
}
