package Utils;

import enumerations.SandwichType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadBasicMenu {

    private String sandwichName;
    private SandwichType sandwichType;
    private double price;

    static List<ReadBasicMenu> readFileList = new ArrayList<>();

    public ReadBasicMenu(String sandwichName, SandwichType sandwichType , double price) {
        this.sandwichName = sandwichName;
        this.sandwichType = sandwichType;
        this.price = price;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public SandwichType getSandwichType() {
        return sandwichType;
    }

    public ReadBasicMenu(double price) {
        this.price = price;
    }

    public void setSandwichType(SandwichType sandwichType) {
        this.sandwichType = sandwichType;
    }

    public double getPrice() {
        return price;
    }

    public static List<ReadBasicMenu> readInput() throws FileNotFoundException {
        String path = "SandwichList";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                ReadBasicMenu r = parseLine(line);
                readFileList.add(r);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return readFileList;
    }
    public static ReadBasicMenu parseLine(String s) {
        String[] parts = s.split(";");
        String name = String.valueOf(parts[0].trim());
        String type = String.valueOf(parts[1].trim().toUpperCase());
        double price = Double.parseDouble(parts[2].trim());
        SandwichType enumType = null;

        if (isValidEnum(SandwichType.class, type)) {
            enumType = SandwichType.valueOf(type);
        } else {
            System.out.println(type + " is NOT a valid  enum");
        }
        return new ReadBasicMenu(name , enumType , price) ;
    }
    public static <T extends Enum<T>> boolean isValidEnum(Class<T> enumClass, String value) {
        try {
            Enum.valueOf(enumClass, value);
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ReadMenu{" +
                "sandwichName='" + sandwichName + '\'' +
                ", sandwichType=" + sandwichType +
                '}';
    }
}
