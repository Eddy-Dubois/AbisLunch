package repository;

import model.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepo {

    List<Ingredients> ingredientsList = new ArrayList<>();

    public IngredientRepo(List<Ingredients> ingredientsList) {
        this.ingredientsList.addAll(ingredientsList);
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    @Override
    public String toString() {
        return "IngredientRepo{" +
                "ingredientsList=" + ingredientsList +
                '}';
    }
}
