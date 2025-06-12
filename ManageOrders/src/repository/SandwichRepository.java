package repository;

import model.Sandwich;
import exception.SandwichAlreadyExistException ;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SandwichRepository {
    static Logger exceptionLogger = LogManager.getLogger("exceptionLogger");
    static Logger infoLogger = Logger.getRootLogger();
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
    }

    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(List<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }

    public void printSandwichList() {
        System.out.println("****** viandes ******");
        sandwichList.stream()
                .filter(sandwich -> sandwich.getSandwichCategory().equalsIgnoreCase("Viandes"))
                .forEach(sandwich -> {
                    System.out.println(sandwich.getSandwichName() +
                            (sandwich.getSandwichVegetableChoice()? "  vegetable (y/n) ": " " ) +
                            "bread g/w " + sandwich.getSandwichPrice() + "€"
                            );
                });
        System.out.println("****** Fish ******");
        sandwichList.stream()
                .filter(sandwich -> sandwich.getSandwichCategory().equalsIgnoreCase("Fish"))
                .forEach(sandwich -> {
                    System.out.println(sandwich.getSandwichName() +
                        (sandwich.getSandwichVegetableChoice()? "  vegetable (y/n) ": " " )+
                            "bread g/w " + sandwich.getSandwichPrice() + "€");
                });
        System.out.println("****** Cheese ******");
        sandwichList.stream()
                .filter(sandwich -> sandwich.getSandwichCategory().equalsIgnoreCase("Cheese"))
                .forEach(sandwich -> {
                    System.out.println(sandwich.getSandwichName() +
                            (sandwich.getSandwichVegetableChoice()? "  vegetable (y/n) ": " " )+
                            "bread g/w " + sandwich.getSandwichPrice() + "€");
                });
        System.out.println("****** Specials ******");
        sandwichList.stream()
                .filter(sandwich -> sandwich.getSandwichCategory().equalsIgnoreCase("Specials"))
                .forEach(sandwich -> {
                    System.out.println(sandwich.getSandwichName() +
                            (sandwich.getSandwichVegetableChoice()? "  vegetable (y/n) ": " " )+
                            "bread g/w " + sandwich.getSandwichPrice() + "€");
                });
        System.out.println("****** Veggie ******");
        sandwichList.stream()
                .filter(sandwich -> sandwich.getSandwichCategory().equalsIgnoreCase("Veggie"))
                .forEach(sandwich -> {
                    System.out.println(sandwich.getSandwichName() +
                            (sandwich.getSandwichVegetableChoice()? "  vegetable (y/n) ": " " )+
                            "bread g/w " + sandwich.getSandwichPrice() + "€");
                });
    }

    public void addSandwich(Sandwich sandwich) throws SandwichAlreadyExistException {
        if (sandwichList.contains(sandwich))
        {   exceptionLogger.error("sandwich \" + sandwich.getSandwichName() + \" already exist");
            infoLogger.info("sandwich \" + sandwich.getSandwichName() + \" already exist");
            throw  new  SandwichAlreadyExistException ("sandwich " + sandwich.getSandwichName() + " already exist");
}
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
        Sandwich sandwich = new Sandwich( tokens[0], tokens[1],tokens[2], vegetableChoice, Double.parseDouble(tokens[3]) ) ;
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
