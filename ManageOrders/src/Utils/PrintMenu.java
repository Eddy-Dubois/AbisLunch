package Utils;

import enumerations.Bread;
import model.MenuItem;
import model.MenuOrder;
import model.Sandwich;
import model.Session;
import repository.SandwichRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PrintMenu {

    public static List<Sandwich> listMenu (SandwichRepository sandwichRepository) {
        List<Sandwich> sandwiches = new ArrayList<>(sandwichRepository.getSandwiches());
        System.out.println("Please choose from the below Menu, Max 2 items");
        System.out.println("-".repeat(100));

        int i = 0;
        for (Sandwich sandwich : sandwiches) {
            System.out.println(++i + "." + sandwich.getName());
        }

        Scanner sc = new Scanner(System.in);
        boolean isOrderComplete = false;
        int inputValue;
        String orderInput = null;
        List<Sandwich> sandwichConfirmed = new ArrayList<>();
        do {
            System.out.print("Input Your Choice from the List: ");
            if (sc.hasNextInt()) {
                inputValue = sc.nextInt();
                if (inputValue <= sandwiches.size()) {
                    int finalInputValue = inputValue;
                    boolean exists = sandwiches.stream().anyMatch(s -> s.equals(sandwiches.get(finalInputValue - 1)));
                    if (exists) {
                        Optional<Sandwich> sandwich = sandwichRepository
                                .findSandwich(sandwiches.get(inputValue - 1).getName());
                        Sandwich sandwitchOrdered = sandwich.map(s -> s).orElse(null);
                        System.out.println("-".repeat(100));
                        if (sandwitchOrdered.isCustomizable()) {
                            System.out.print("Your choice needs more Input..");
                            System.out.println("-".repeat(100));
                            System.out.println("Select Groenten (Y/N): ");
                            if (sc.nextLine().equalsIgnoreCase("Y")) {
                                sandwitchOrdered.setHasVeggies(true);
                            } else {
                                sandwitchOrdered.setHasVeggies(false);
                            }
                        }
                        System.out.println("Select Your Choice of Bread (Gris/Wit): ");
                        sandwitchOrdered.setBreadType(Bread.valueOf(sc.nextLine()));

                        sandwichConfirmed.add(sandwitchOrdered);
                        System.out.println("-".repeat(100));
                        System.out.println("Do you want to add another item (Y/N) ? ");
                        orderInput = sc.nextLine();
                    } else {
                        System.out.println("Invalid input! Please enter a valid Id. Try Again!!!");
                    }
                }
            } else {
                System.out.println("Invalid input! Please enter a valid Id. Try Again!!!");
            }

        }
        return sandwichConfirmed;
    }while(!(orderInput.equalsIgnoreCase("y")))
    }
}
