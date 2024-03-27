import java.util.Scanner;

/**
 * PaymentListTester Class: Tester class for PaymentList class.
 * @author Adrian Adewunmi
 * @version 8th January 2021
 * Reproduced from "Java in Two Semesters: Featuring JavaFX. Springer" (Case Study - Part 1 / Case Study - Part 2).
 * Charatan, Q., & Kans, A. (2019). Java in Two Semesters: Featuring JavaFX. Springer.
 */

public class PaymentListTester {

    public static void main(String[] args) {
        char choice;
        int size;
        PaymentList list; // declare PaymentList object to test
        
        // get size of list
        System.out.println("** Testing PaymentList Class **");
        System.out.println();
        System.out.println("Size of list? ");
        Scanner scannerInt = new Scanner(System.in);
        size = scannerInt.nextInt();
        list = new PaymentList(size); // create object to test
        
        // menu
        do {
            // display options
            System.out.println();
            System.out.println("[1] ADD PAYMENT");
            System.out.println("[2] DISPLAY PAYMENT");
            System.out.println("[3] PAYMENT LIST STATUS");
            System.out.println("[4] GET PAYMENT");
            System.out.println("[5] GET TOTAL");
            System.out.println("[6] CALCULATE TOTAL PAID");
            System.out.println("[7] Quit");
            System.out.println();
            System.out.println("Enter a choice [1 - 7]: ");
            // get choice
            Scanner scannerChar = new Scanner(System.in);
            choice = scannerChar.next().charAt(0);
            System.out.println();
            // process choice
            switch (choice){
                case '1': option1(list); break;
                case '2': option2(list); break;
                case '3': option3(list); break;
                case '4': option4(list); break;
                case '5': option5(list); break;
                case '6': option6(list); break;
                case '7': System.out.println("TESTING COMPLETE"); break;
                default: System.out.println("1 - 7 only");
            }
        }while(choice != '7');
    }

    // GET TOTAL PAID
    private static void option6(PaymentList listIn) {
        System.out.println("TOTAL OF PAYMENTS MADE SO FAR: ");
        System.out.println(listIn.calculateTotalPaid());
    }

    // GET TOTAL
    private static void option5(PaymentList listIn) {
        System.out.println("TOTAL NUMBER OF PAYMENTS ENTERED: ");
        System.out.println(listIn.getTotal());
    }

    // GET PAYMENT
    private static void option4(PaymentList listIn) {
        // prompt for and receive payment number
        System.out.println("Enter payment number to retrieve: ");
        Scanner scannerInt1 = new Scanner(System.in);
        int num = scannerInt1.nextInt();
        // retrieve Payment object from list
        Payment payment = listIn.getPayment(num); // returns null if invalid position
        if(payment != null) // check if Payment retrieved
        {
            System.out.println(payment); // calls toString method of Payment
        }else{
            System.out.println("INVALID PAYMENT NUMBER"); // invalid position error
        }
    }

    // IS FULL
    private static void option3(PaymentList listIn) {
        if(listIn.isFull()){
            System.out.println("List is full");
        }else{
            System.out.println("List is NOT full");
        }
    }

    // DISPLAY
    private static void option2(PaymentList listIn) {
        System.out.println("ITEMS ENTERED");
        System.out.println(listIn); // calls toString method of PaymentList
    }

    // ADD
    private static void option1(PaymentList listIn) {
        // prompt for payment details
        System.out.println("Enter Month: ");
        Scanner scannerStr = new Scanner(System.in);
        String month = scannerStr.next();
        System.out.println("Enter Amount: ");
        Scanner scannerDbl = new Scanner(System.in);
        double amount = scannerDbl.nextDouble();
        // create new Payment object from input
        Payment payment = new Payment(month, amount);
        // attempt to add payment to list
        boolean ok = listIn.addPayment(payment); // value of false sent back if unable to add
        if(!ok) // check if item was not added
        {
            System.out.println("ERROR: list full");
        }
    }

}
