package model;

import Interfaces.CustomComposition;

import java.util.Objects;

public class Sandwich implements CustomComposition {

    private String sandwichName ;
    private String sandwichCategory ;
    private String sandwichDescription ;
    private boolean sandwichVegetableChoice ;
    private double sandwichPrice ;

    public Sandwich(String sandwichName, String sandwichCategory, String sandwichDescription,
                    boolean vegetableChoice, double sandwichPrice) {

        this.sandwichName = sandwichName;
        this.sandwichCategory = sandwichCategory;
        this.sandwichVegetableChoice = isVegetableChoiceAllowed(sandwichCategory) ;
        this.sandwichDescription = sandwichDescription;
        this.sandwichPrice = sandwichPrice ;
    }

    public double getSandwichPrice() {
        return sandwichPrice;
    }

    public boolean getSandwichVegetableChoice() {
        return sandwichVegetableChoice;
    }

    public void setSandwichVegetableChoice(boolean sandwichVegetableChoice) {
        this.sandwichVegetableChoice = sandwichVegetableChoice;
    }

    public void setSandwichPrice(double sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public String getSandwichCategory() {
        return sandwichCategory;
    }

    public void setSandwichCategory(String sandwichCategory) {
        this.sandwichCategory = sandwichCategory;
    }

    public String getSandwichDescription() {
        return sandwichDescription;
    }

    public void setSandwichDescription(String sandwichDescription) {
        this.sandwichDescription = sandwichDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sandwich sandwich = (Sandwich) o;
        return Objects.equals(sandwichName, sandwich.sandwichName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sandwichName);
    }

    @Override
    public boolean isVegetableChoiceAllowed(String category) {
        boolean vegetableChoice = false ;
        if (category.equalsIgnoreCase(FISH) || category.equalsIgnoreCase(MEAT) || category.equalsIgnoreCase(CHEESE))
            vegetableChoice = true ;
        return vegetableChoice;
    }
}
