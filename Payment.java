/**
 * Payment Class: Used to store details of a single payment in a hostel.
 * @author Adrian Adewunmi
 * @version 8th January 2021
 * Reproduced from "Java in Two Semesters: Featuring JavaFX. Springer" (Case Study - Part 1 / Case Study - Part 2).
 * Charatan, Q., & Kans, A. (2019). Java in Two Semesters: Featuring JavaFX. Springer.
*/

public class Payment {

    private final String month;
    private final double amount;

    /**
    Constructor initialises the payment month and the amount paid
    @param monthIn: month of payment
    @param amountIn: amount of payment
     */

    public Payment(String monthIn, double amountIn) {
        this.month = monthIn;
        this.amount = amountIn;
    }

    /**
    Reads the month for which payment was made
    @return Returns the month for which payment was made
     */

    public String getMonth() {
        return month;
    }

    /**
    Reads the amount paid
    @return Returns the amount paid
     */
    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "(" + month + ", " + amount + ")"; // a convenient way of displaying attributes
    }
}
