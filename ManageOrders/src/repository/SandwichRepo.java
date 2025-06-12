package repository;

import Utils.ReadBasicMenu;
import Utils.ReadSpecials;
import model.*;

import java.io.FileNotFoundException;
import java.util.*;

public class SandwichRepo {

    private List<MenuItem> sandwiches = new ArrayList<>();
    private static Set<MenuItem> menuItems =  new TreeSet<>(Comparator.comparing(MenuItem::getName));
    private static Set<Ingredients> ingredients = new TreeSet<>(Comparator.comparing(Ingredients::getIngredient));
    private static Map<String, List<Ingredients>> sandwichToIngredients = new HashMap<>();


    public SandwichRepo() throws FileNotFoundException {
        loadMenu();
    }

    public List<MenuItem> getSandwiches() {
        return sandwiches;
    }

    public static Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public static Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public static Map<String, List<Ingredients>> getSandwichToIngredients() {
        return sandwichToIngredients;
    }

    private void loadMenu() throws FileNotFoundException {

        List<ReadBasicMenu> readMenu = ReadBasicMenu.readInput();
        List <MenuItem> sandwichList = new ArrayList<>();
        for (ReadBasicMenu rm : readMenu) {
            MenuItem s = new MenuItem(rm.getSandwichName(), true, rm.getSandwichType() , rm.getPrice()) ;
            assert sandwiches != null;
            sandwiches.add(s);
        }

        List<ReadSpecials> readSpecials = ReadSpecials.readInput();
        for (ReadSpecials rs : readSpecials) {
            IngredientRepo ingredientRepo = new IngredientRepo(rs.getIngredients());
            MenuItem s = new MenuItem(rs.getSandwichName(), false, rs.getSandwichType(), ingredientRepo , rs.getPrice()) ;
            sandwiches.add(s);
            sandwichToIngredients.put(s.getName(),rs.getIngredients());
        }

    }


    public Optional<MenuItem> findSandwich(String name) {
        return Optional.ofNullable(sandwiches.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No Person Found")));



    }
}