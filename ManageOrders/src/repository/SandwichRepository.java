package repository;

import Utils.ReadBasicMenu;
import Utils.ReadSpecials;
import model.Ingredients;
import model.Sandwich;

import java.io.FileNotFoundException;
import java.util.*;

public class SandwichRepository {

    private List<Sandwich> sandwiches = new ArrayList<>();
    private static Set<Sandwich> sandwichList =  new TreeSet<>(Comparator.comparing(Sandwich::getName));
    private static Set<Ingredients> ingredients = new TreeSet<>(Comparator.comparing(Ingredients::getIngredient));
    private static Map<String, List<Ingredients>> sandwichToIngredients = new HashMap<>();

    public SandwichRepository() throws FileNotFoundException {
        loadMenu();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public Map<String, List<Ingredients>> getSandwichToIngredients() {
        return sandwichToIngredients;
    }

    private void loadMenu() throws FileNotFoundException {

        List<ReadBasicMenu> readMenu = ReadBasicMenu.readInput();
        for (ReadBasicMenu rm : readMenu) {
            Sandwich s = new Sandwich(rm.getSandwichName(), true, rm.getSandwichType() , rm.getPrice()) ;
            sandwichList.add(s);
        }

        List<ReadSpecials> readSpecials = ReadSpecials.readInput();
        for (ReadSpecials rs : readSpecials) {
            IngredientRepo ingredientRepo = new IngredientRepo(rs.getIngredients());
            Sandwich s = new Sandwich(rs.getSandwichName(), false, rs.getSandwichType(), ingredientRepo , rs.getPrice()) ;
            sandwichList.add(s);
            sandwichToIngredients.put(s.getName(),rs.getIngredients());
        }
        this.sandwiches.addAll(sandwichList);

    }
    public Optional<Sandwich> findSandwich (String name){
        return sandwiches.stream()
                .filter(s-> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
