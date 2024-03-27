/**
 * Tenant Class: Used to record the details of a tenant.
 * @author Adrian Adewunmi
 * @version 10 January 2021
 * Reproduced from "Java in Two Semesters: Featuring JavaFX. Springer" (Case Study - Part 1 / Case Study - Part 2).
 * Charatan, Q., & Kans, A. (2019). Java in Two Semesters: Featuring JavaFX. Springer.
 */

public class Tenant {

    private final String name;
    private final int room;
    private final PaymentList payments;
    public static final int MAX = 12;

    /**
     * Constructor initialises the name and room number of the tenant
     * and sets the payments made to the empty list
     * @param nameIn: name of tenant
     * @param roomIn: room number of tenant
     */

    public Tenant(String nameIn, int roomIn) {
        this.name = nameIn;
        this.room = roomIn;
        this.payments = new PaymentList(MAX);
    }

    /**
     * Records a payment for the tenant
     * @param paymentIn: payment made by tenant
     */

    public void makePayment(Payment paymentIn){
        payments.addPayment(paymentIn);
    }

    /**
     * Reads the name of the tenant
     * @return Returns the name of the tenant
     */

    public String getName(){
        return name;
    }

    /**
     * Reads the room of the tenant
     * @return Return the room of the tenant
     */

    public int getRoom(){
        return room;
    }

    /**
     * Reads the payments of the tenant
     * @return Returns the payment made by the tenant
     */

    public PaymentList getPayments(){
        return payments;
    }


    @Override
    public String toString() {
        return name + ", " + room + ", " + payments;
    }
}
