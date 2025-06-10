package Model;

import enumeration.SandwichCategory;

import java.util.Objects;

public class Sandwich {

    private String sandwichName ;
    private String sandwichCategory ;
    private String sandwichDescription ;
    private boolean vegetableChoice ;

    public Sandwich(String sandwichName, String sandwichCategory, String sandwichDescription, boolean vegetableChoice) {

        this.sandwichName = sandwichName;
        this.sandwichCategory = sandwichCategory;
        this.sandwichDescription = sandwichDescription;
        this.vegetableChoice = vegetableChoice;
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

    public boolean isVegetableChoice() {
        return vegetableChoice;
    }

    public void setVegetableChoice(boolean vegetableChoice) {
        this.vegetableChoice = vegetableChoice;
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
}
