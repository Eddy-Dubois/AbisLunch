package Repository;

import Model.Person;
import Model.Sandwich;
import Exception.SandwichAlreadyExistException ;
import Exception.SandwichNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SandwichRepository {
    static String fileLocation = "C:/temp/javacourses/sandwiches.csv";
    private List<Sandwich> sandwichList = new ArrayList<>();
/*
    public SandwichRepository() {
        System.out.println("creating sandwiches");
        Sandwich sm1 = new Sandwich("Jambon", "Viandes", "Jambon", true);
        Sandwich sm2 = new Sandwich("Rosbif", "Viandes", "Rosbif", true);


        Sandwich ss1 = new Sandwich("Pinky", "Specials", "Salade, Tomates", false);
        Sandwich ss2 = new Sandwich("Hawaiien", "Specials", "Ananas, Jambon", false);
        sandwichList.addAll(Arrays.asList(new Sandwich[]{sm1, sm2, ss1, ss2}));
        printSandwichList();

    }
*/
    public SandwichRepository () {
        readFile();
        printSandwichList();
    }

    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(List<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }

    public void printSandwichList() {
        System.out.println("***** sandwich list *****");
        for (Sandwich sandwich : sandwichList) {
            System.out.println(sandwich.getSandwichName() +
                    (sandwich.isVegetableChoice()? "  vegetable (y/n) ": "" ));
        }
    }

    public void addSandwich(Sandwich sandwich) throws SandwichAlreadyExistException {
        if (sandwichList.contains(sandwich))
            throw new  SandwichAlreadyExistException ("sandwich " + sandwich.getSandwichName() + " already exist");
        else {
            sandwichList.add(sandwich);
            System.out.println("sandwich added");
        }
    }

    public void removeSandwich(String name) {
        Iterator<Sandwich> sandwichIterator = sandwichList.iterator();
        Sandwich sandwich = null;
        while (sandwichIterator.hasNext()) {
            sandwich = sandwichIterator.next();
            if (sandwich.getSandwichName().equals(name)) {
                System.out.println("the one to remove : " + sandwich.getSandwichName());
                sandwichIterator.remove();
            }
        }
    }
    public Sandwich parseSandwich (String s){
        String [] tokens = s.split(";");
        Boolean vegetableChoice = false;
        if (tokens[3].equalsIgnoreCase("Y")) {
            vegetableChoice = true;
        }
        Sandwich sandwich = new Sandwich( tokens[0], tokens[1],tokens[2], vegetableChoice ) ;
        return sandwich;
    }
    public void readFile(){
        Path path = Paths.get(fileLocation);
        Sandwich sandwich ;
        try (BufferedReader br = Files.newBufferedReader(path)){
            String currentLine = null ;
            while ((currentLine = br.readLine()) != null) {
                sandwich = parseSandwich(currentLine);
                sandwichList.add(sandwich);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void writeFile () {
        // not yet done
    }
}
