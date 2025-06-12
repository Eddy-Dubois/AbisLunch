package repository;

import java.util.ArrayList;
import java.util.List;

public class IngredientRepo {

    List<model.Ingredients> ingredientsList = new ArrayList<>();

    public IngredientRepo(List<model.Ingredients> ingredientsList) {
        this.ingredientsList.addAll(ingredientsList);
    }




    public List<model.Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    @Override
    public String toString() {
        return "IngredientRepo{" +
                "ingredientsList=" + ingredientsList +
                '}';
    }
}
