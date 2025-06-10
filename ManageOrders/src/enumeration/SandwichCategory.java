package enumeration;

public enum SandwichCategory {
    MEAT ("Viandes", "Vlees"),
    CHEESE ("Fromage", "Kaas");

    private final String frenchName;
    private final String dutchName;

    public String getFrenchName() {
        return frenchName;
    }

    public String getDutchName() {
        return dutchName;
    }

    SandwichCategory(String frenchName, String dutchName) {
        this.frenchName = frenchName;
        this.dutchName = dutchName;
    }
}
