package enumeration;

public enum BreadType {
    BROWN ("B","Bruin", "Gris"),
    WHITE ("W", "Wit", "Blanc");

    private final String breadTypeAbr ;
    private final String breadTyNl ;
    private final String breadTypeFr ;

    public String getBreadTypeAbr() {
        return breadTypeAbr;
    }

    public String getBreadTyNl() {
        return breadTyNl;
    }

    public String getBreadTypeFr() {
        return breadTypeFr;
    }

    BreadType(String breadTypeAbr , String breadTyNl, String breadTypeFr) {
        this.breadTypeAbr = breadTypeAbr ;
        this.breadTyNl = breadTyNl;
        this.breadTypeFr = breadTypeFr;
    }
}
