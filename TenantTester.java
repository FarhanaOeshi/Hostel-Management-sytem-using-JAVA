/**
 * TenantTester Class: Tester class for Tenant class.
 * @author Adrian Adewunmi
 * @version 24th January 2021
 */

public class TenantTester {

    public static void main(String[] args) {
        // Tenant 1
        Tenant tenantOne = new Tenant("James", 1);
        Payment tenantOneP1 = new Payment("January", 300);
        tenantOne.makePayment(tenantOneP1);
        Payment tenantOneP2 = new Payment("February", 310);
        tenantOne.makePayment(tenantOneP2);
        Payment tenantOneP3 = new Payment("March", 320);
        tenantOne.makePayment(tenantOneP3);
        tenantOne.getPayments();
        System.out.println(tenantOne.toString());

        // Tenant 2
        Tenant tenantTwo = new Tenant("Adele", 2);
        Payment tenantTwoP1 = new Payment("July", 400);
        tenantTwo.makePayment(tenantTwoP1);
        Payment tenantTwoP2 = new Payment("August", 410);
        tenantTwo.makePayment(tenantTwoP2);
        Payment tenantTwoP3 = new Payment("September", 420);
        tenantTwo.makePayment(tenantTwoP3);
        tenantOne.getPayments();
        System.out.println(tenantTwo.toString());
        System.out.println(tenantOne.getName());
        System.out.println(tenantOne.getRoom());
        System.out.println(tenantOne.getPayments());

    }

}
