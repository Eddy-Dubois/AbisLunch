package model;

import enumerations.Bread;
import enumerations.SandwichType;
import repository.IngredientRepo;

public class MenuItem {

    String name;
    IngredientRepo ingredientRepo;
    boolean isCustomizable;
    Bread breadType;
    SandwichType type;
    boolean hasVeggies;
    double price;

    public MenuItem(String name, boolean isCustomizable, SandwichType type, IngredientRepo ingredientRepo , double price) {
        this.name = name;
        this.isCustomizable = isCustomizable;
        this.type = type;
        this.ingredientRepo = ingredientRepo;
        this.price = price;
    }

    public MenuItem(String name, boolean isCustomizable, SandwichType type , double price) {
        this.name = name;
        this.isCustomizable = isCustomizable;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public IngredientRepo getIngredientRepo() {
        return ingredientRepo;
    }

    public boolean isCustomizable() {
        return isCustomizable;
    }

    public Bread getBreadType() {
        return breadType;
    }

    public SandwichType getType() {
        return type;
    }

    public boolean isHasVeggies() {
        return hasVeggies;
    }

    public void setBreadType(Bread breadType) {
        this.breadType = breadType;
    }

    public void setHasVeggies(boolean hasVeggies) {
        this.hasVeggies = hasVeggies;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "name='" + name + '\'' +
                ", ingredientRepo=" + ingredientRepo +
                ", isCustomizable=" + isCustomizable +
                ", breadType=" + breadType +
                ", type=" + type +
                ", hasVeggies=" + hasVeggies +
                '}';
    }
}
