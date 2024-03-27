import java.util.Scanner;

/**
 * TenantListTester Class: Tester class for TenantList class.
 * @author Adrian Adewunmi
 * @version 24th January 2021
 */

public class TenantListTester {

    public static void main(String[] args) {
        char choice;
        int total;
        TenantList list; // declare TenantList object to test

        // get total of list
        System.out.println("** Testing TenantList Class **");
        System.out.println();
        System.out.println("How many tenants will be staying ? ");
        Scanner scannerInt = new Scanner(System.in);
        total = scannerInt.nextInt();
        list = new TenantList(total); // create object to test

        // menu
        do {
            // display options
            System.out.println();
            System.out.println("[1] ADD TENANT");
            System.out.println("[2] LIST ALL TENANTS");
            System.out.println("[3] ADD A PAYMENT");
            System.out.println("[4] LIST PAYMENTS");
            System.out.println("[5] REMOVE A TENANT");
            System.out.println("[6] QUIT");
            System.out.println();
            System.out.println("Enter a choice [1 - 6]: ");
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
                case '6': System.out.println("TESTING COMPLETE!!!"); break;
                default: System.out.println("1 - 6 only");
            }
        }while(choice != '6');


    }

    // REMOVE A TENANT
    private static void option5(TenantList listIn) {
        // get room number of tenant
        System.out.print("\nEnter room number of tenant:\t");
        Scanner scannerRemoveTent = new Scanner(System.in);
        int room = scannerRemoveTent.nextInt();
        // check tenant exists
        Tenant tenant = listIn.search(room);
        if (tenant != null)// only remove if tenant exists
        {
            listIn.removeTenant(room);
        }
        else // no tenant in given room
        {
            System.out.print("\n!!! NO TENANT IN THIS ROOM!!! \n");
        }
    }

    // LIST PAYMENT
    private static void option4(TenantList listIn) {
        // get room number of tenant
        System.out.print("\nEnter room number of tenant: \t");
        Scanner scannerRoom = new Scanner(System.in);
        int room = scannerRoom.nextInt();
        // find relevant tenant
        Tenant tenant = listIn.search(room);
        if (tenant != null)// check such a tenant exists before displaying
        {
            PaymentList payments = tenant.getPayments();
            System.out.print("\nMONTH \tAMOUNT\n");// header
            // loop through payments in list
            for (int i =1; i <= payments.getTotal();i++)
            {
                Payment payment = payments.getPayment(i);
                System.out.print(payment.getMonth());
                System.out.println("\t" + payment.getAmount());
            }
            // display total amount paid
            System.out.print("\nTOTAL PAID: \t");
            System.out.println(payments.calculateTotalPaid());
        }
        else // no tenant with given room number found
        {
            System.out.print("\n!!!NO TENANT IN THIS ROOM!!! \n");
        }

    }

    // ADD A PAYMENT
    private static void option3(TenantList listIn) {
        // get room number of tenant
        System.out.println("\nEnter room number of tenant:\t");
        Scanner scannerRoomNumb = new Scanner(System.in);
        int roomNumb = scannerRoomNumb.nextInt();
        // Find relevant tenant
        Tenant tenant = listIn.search(roomNumb);
        if(tenant != null) // check tenant exists before adding payment
        {
            System.out.println("\nEnter month: \t");
            Scanner scannerMonth = new Scanner(System.in);
            String month = scannerMonth.next();
            System.out.println("\nEnter amount: \t");
            Scanner scannerAmount = new Scanner(System.in);
            double amount = scannerAmount.nextDouble();
            Payment payment = new Payment(month, amount);
            tenant.makePayment(payment);
        }else // no tenant with given room number found
        {
            System.out.println("\n!!!NO TENANT IN THIS ROOM!!! \n");
        }
    }

    // LIST TENANT
    private static void option2(TenantList listIn) {
        System.out.println("\nNAME \tROOM\n"); // Header
        for (int i = 1; i < listIn.getTotal() + 1; i++) {
            Tenant tenant = listIn.getTenant(i);
            System.out.print(tenant.getName());
            System.out.println("\t     " + tenant.getRoom());
        }
    }

    // ADD TENANT
    private static void option1(TenantList listIn) {
        if(!listIn.isFull()) // only add if list is not full
        {
            // prompt for tenant details
            System.out.println("Enter Name: ");
            Scanner scannerStr = new Scanner(System.in);
            String tenantName = scannerStr.next();
            System.out.println("Enter Room Number: ");
            Scanner scannerInt = new Scanner(System.in);
            int tenantRoomNumb = scannerInt.nextInt();
            // create new Tenant object from input
            Tenant tenant = new Tenant(tenantName, tenantRoomNumb);
            // attempt to add tenant to list
            listIn.addTenant(tenant); // value of false sent back if unable to add 
        }else // error message if list is full
        {
            System.out.println("ERROR: LIST FULL");
        }
    }

}
