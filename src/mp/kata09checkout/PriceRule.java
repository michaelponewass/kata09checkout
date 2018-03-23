package mp.kata09checkout;

/**
 * Created by michael.ponewass on 23.03.2018.
 */
public interface PriceRule {
    /**
     * get the total price
     *
     * @param amount the amount of items
     * @param price  the normal item price
     * @return calculated price
     */
    double getTotal(int amount, double price);
}
