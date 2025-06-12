package model;

import java.util.Objects;

public class Ingredients {

    private String ingredient;

    public String getIngredient() {
        return ingredient;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredient='" + ingredient + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredients that)) return false;
        return Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ingredient);
    }

    public Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }
}
