package Utils;

import java.util.Scanner;

public class PrintLoginPage {

    public static int printLogin () {

        System.out.println("-".repeat(100));
        String s = "Ordering Service" ;
        System.out.printf("%" + ((( 100 - s.length()) / 2) + s.length())+ "s%n" , s);
        System.out.println("-".repeat(100));
        System.out.printf("%-80s%n", "Select Profile");
        System.out.println("-".repeat(100));
        System.out.printf("%-80s%n%-80s%n%-80s%n%-80s%n%-80s%n", "1.Student","2.Instructor",
                "3.Accountant","4.OfficeManager","5.GeneralManager");
        System.out.println("-".repeat(100));

        Scanner sc = new Scanner(System.in);
        int role ;

        // Loop until valid input is provided
        while (true) {
            System.out.print("Select Your Role (1-5): ");
            if (sc.hasNextInt()) { // Check if input is an integer and within range
                role = sc.nextInt();
                if (role >= 1 && role <= 5) {
                    break;
                }else{
                    System.out.println("Invalid input! Please enter a valid role Id. Try Again!!!");
                }

            } else {
                System.out.println("Invalid input! Please enter a valid role Id. Try Again!!!");
            }
        }
        String roleName = null;
        switch (role){
            case 1: roleName = "Student";break;
            case 2: roleName = "Instructor";break;
            case 3: roleName = "Accountant";break;
            case 4: roleName = "OfficeManager";break;
            case 5: roleName = "GeneralManager";break;
        }
        System.out.println("Welcome !!! You are logged in as : " + roleName);
        return role;
    }
}
