/**
 * PaymentTester Class: Tester class for Payment class.
 * @author Adrian Adewunmi
 * @version 8th January 2021
 * Reproduced from "Java in Two Semesters: Featuring JavaFX. Springer" (Case Study - Part 1 / Case Study - Part 2).
 * Charatan, Q., & Kans, A. (2019). Java in Two Semesters: Featuring JavaFX. Springer.
 */


public class PaymentTester {
    public static void main(String[] args) {
        Payment p1 = new Payment("January", 310);
        Payment p2 = new Payment("February", 280);
        Payment p3 = new Payment("March", 175);
        // code to interrogate object data
        //System.out.println("Month: " + p1.getMonth());
        //System.out.println("Amount " + p1.getAmount());
        System.out.println("** Testing Payment Class **");
        System.out.println();
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
