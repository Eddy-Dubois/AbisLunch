package Utils;

import model.Ingredients;
import enumerations.SandwichType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Utils.ReadBasicMenu.isValidEnum;

public class ReadSpecials {

    private String sandwichName;
    private SandwichType sandwichType;
    private List<Ingredients> ingredients = new ArrayList<>();
    private double price;

    static List<ReadSpecials> readFileList = new ArrayList<>();

    public ReadSpecials(String sandwichName, SandwichType sandwichType, List<Ingredients> ingredients , double price) {
        this.sandwichName = sandwichName;
        this.sandwichType = sandwichType;
        this.ingredients = ingredients;
        this.price = price;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public SandwichType getSandwichType() {
        return sandwichType;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }

    public static List<ReadSpecials> readInput() throws FileNotFoundException {
        String path = "Specials";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                ReadSpecials r = parseLine(line.replace(")", ",").replace("\t" , " ").replaceAll("\\s+", " "));
                readFileList.add(r);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return readFileList;
    }
    public static ReadSpecials parseLine(String s) {
        String[] parts = s.split("[,();]");
        List<Ingredients> ingredientsList = new ArrayList<>();

        String name = parts[0].trim();
        String type  = parts[parts.length - 2].trim().toUpperCase();
        double price = Double.parseDouble(parts[parts.length - 1]) ;
        SandwichType enumType = null;
        for (int i = 1 ; i < parts.length - 2 ; i++){
            if (parts[i] != null && !parts[i].isBlank()) {
                ingredientsList.add(new Ingredients(parts[i].trim()));
            }
        }
        if (isValidEnum(SandwichType.class, type)) {
            enumType = SandwichType.valueOf(type);
        } else {
            System.out.println(type + " is NOT a valid  enum");
        }
        return new ReadSpecials(name, enumType, ingredientsList , price) ;
    }
}
