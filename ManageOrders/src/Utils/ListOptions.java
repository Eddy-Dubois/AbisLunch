package Utils;

import java.util.Scanner;

public class ListOptions {

    public static String printList (int role) {
        System.out.println("You are Entitled to:");
        switch (role){
            case 1:
                System.out.println("Add Order");break;
            case 2:
                System.out.println("Add Order");break;
            case 3:
                System.out.println("Calculate Total Price");break;
            case 4:
                System.out.println("""
                        1. Add Order
                        2. Remove Order
                        3. Print Order List
                        4. Save In History""");
                break;
            case 5:
                System.out.println("View Stats");break;
        }
        System.out.println("-".repeat(100));
        Scanner sc = new Scanner(System.in);
        if (role == 4){
            System.out.print("Choose One Option (1 or 2 or 3): ");
        }else {
            System.out.println("Enter to Proceed...");
        }
        String userChoice = sc.nextLine() ;

        System.out.println("-".repeat(100));

        return userChoice;
    }
}
