package Utils;

import enumerations.Bread;
import enumerations.SandwichType;
import model.MenuItem;
import model.MenuOrder;
import model.Sandwich;
import model.Session;
import repository.SandwichRepository;

import java.time.LocalDate;
import java.util.*;

public class PrintMenu {

    public static List<Sandwich> listMenu (SandwichRepository sandwichRepository) {
        List<Sandwich> sandwiches = new ArrayList<>(sandwichRepository.getSandwiches());
        sandwiches.sort(Comparator.comparing(Sandwich::getType));
        System.out.println("Please choose from the below Menu, Max 2 items");

        int i = 0;
        SandwichType last = null;
        for (Sandwich sandwich : sandwiches) {
            if (sandwich.getType() != last) {
                System.out.println("-".repeat(100));
                System.out.println(sandwich.getType());
                System.out.println("-".repeat(100));

                last = sandwich.getType();
            }
            System.out.println(++i + "." + sandwich.getName());

        }
        System.out.println("-".repeat(100));
        Scanner sc = new Scanner(System.in);
        boolean isOrderComplete = false;
        int inputValue;
        String orderInput = null;
        int orderCounter = 0;
        List<Sandwich> sandwichConfirmed = new ArrayList<>();
        do {
            System.out.print("Input Your Choice from the List: ");
            if (sc.hasNextInt()) {
                inputValue = sc.nextInt();
                sc.nextLine();
                if (inputValue <= sandwiches.size()) {
                    int finalInputValue = inputValue;
                    boolean exists = sandwiches.stream().anyMatch(s -> s.equals(sandwiches.get(finalInputValue - 1)));
                    if (exists) {
                        Optional<Sandwich> sandwich = sandwichRepository
                                .findSandwich(sandwiches.get(inputValue - 1).getName());
                        Sandwich sandwitchOrdered = sandwich.map(s -> s).orElse(null);
                        System.out.println("-".repeat(100));
                        if (sandwitchOrdered.isCustomizable()) {
                            System.out.println("Your choice needs more Input..");
                            System.out.println("-".repeat(100));
                            System.out.println("Select Groenten (Y/N): ");
                            if (sc.nextLine().equalsIgnoreCase("Y")) {
                                sandwitchOrdered.setHasVeggies(true);
                            } else {
                                sandwitchOrdered.setHasVeggies(false);
                            }
                        }
                        System.out.println("Select Your Choice of Bread (Gris/Wit): ");
                        String enuminput = sc.nextLine();

                        sandwitchOrdered.setBreadType(Bread.valueOf(enuminput.toUpperCase()));

                        sandwichConfirmed.add(sandwitchOrdered);
                        orderCounter++;
                        System.out.println("-".repeat(100));
                        System.out.println("Do you want to add another item (Y/N) ? ");
                        orderInput = sc.nextLine();
                        if ((orderInput.equalsIgnoreCase("Y")) && orderCounter == 2){
                            System.out.println("Max Limit Reached!!! Placing Order!!!");
                            orderInput = "N" ;
                            System.out.println("-".repeat(100));
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a valid Id. Try Again!!!");
                    }
                }
            } else {
                System.out.println("Invalid input! Please enter a valid Id. Try Again!!!");
            }

        }while(orderInput.equalsIgnoreCase("Y"));
        return sandwichConfirmed;

    }
}
