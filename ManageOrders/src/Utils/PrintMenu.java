package Utils;

import enumerations.Bread;
import enumerations.SandwichType;
import model.*;
import repository.SandwichRepo;

import java.util.*;

public class PrintMenu {

    public static List<MenuItem> listMenu (SandwichRepo sandwichRepository, Map<String , List<Ingredients>> ingredientsMap) {
        List<MenuItem> menuItems = new ArrayList<>(sandwichRepository.getSandwiches());
        menuItems.sort(Comparator.comparing(MenuItem::getType));
        System.out.println("Please choose from the below Menu, Max 2 items");

        int i = 0;
        SandwichType last = null;
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getType() != last) {
                System.out.println("-".repeat(100));
                System.out.println(menuItem.getType());
                System.out.println("-".repeat(100));

                last = menuItem.getType();
            }
            System.out.println(++i + "." + menuItem.getName());

        }
        System.out.println("-".repeat(100));
        Scanner sc = new Scanner(System.in);
        boolean isOrderComplete = false;
        int inputValue;
        String orderInput = null;
        int orderCounter = 0;
        List<MenuItem> menuItemConfirmed = new ArrayList<>();
        do {
            System.out.print("Input Your Choice from the List: ");
            if (sc.hasNextInt()) {
                inputValue = sc.nextInt();
                sc.nextLine();
                if (inputValue <= menuItems.size()) {
                    int finalInputValue = inputValue;
                    boolean exists = menuItems.stream().anyMatch(s -> s.equals(menuItems.get(finalInputValue - 1)));
                    if (exists) {
                        Optional<MenuItem> sandwich = sandwichRepository
                                .findSandwich(menuItems.get(inputValue - 1).getName());
                        MenuItem sandwitchOrdered = sandwich.map(s -> s).orElse(null);
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
                        }else{
                            System.out.println("Do you want to see the ingredients (Y/N): ");
                            String listIngredients = sc.nextLine();
                            if (listIngredients.equalsIgnoreCase("Y")) {
                                for (Map.Entry<String, List<Ingredients>> entry : ingredientsMap.entrySet()) {
                                    String key = entry.getKey();
                                    List<Ingredients> ingredientsList = entry.getValue();

                                    System.out.println("Category: " + key); // or "Key" if not a category

                                    for (Ingredients ingredient : ingredientsList) {
                                        System.out.println("  - " + ingredient.getIngredient()); // assuming Ingredients has getName()
                                    }
                                }
                            }
                        }
                        System.out.println("Select Your Choice of Bread (Gris/Wit): ");
                        String enuminput = sc.nextLine();

                        sandwitchOrdered.setBreadType(Bread.valueOf(enuminput.toUpperCase()));


                        menuItemConfirmed.add(sandwitchOrdered);
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
        return menuItemConfirmed;

    }
}
