package repository;

import model.Sandwich;
import enumeration.BreadType ;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;

public class ManagerRepository {
    static String fileLocation = "C:/temp/javacourses/orderoftheday.txt";
    static String historyFileLocation = "C:/temp/javacourses/ordershistory.txt";

    public void printOrdersOfTheDay () {
        readFile();
    }

    public void readFile() {
        Path path = Paths.get(fileLocation);
        Sandwich sandwich;
        try (BufferedReader br = Files.newBufferedReader(path)) {
    //      skip title line
            String currentLine = null ;
            br.readLine();
            System.out.println("-".repeat(60));
            System.out.println(" ".repeat(24) + "Abis Company" + " ".repeat(24));
            System.out.println("-".repeat(60));
            System.out.println("Naam" + " ".repeat(16) + "Sandwich" + " ".repeat(12) +
                               "Brood" + " ".repeat(5) + "Groeten" );
            System.out.println("-".repeat(60));
            while ((currentLine = br.readLine()) != null) {
                String[] tokens = currentLine.split(";");
                String bread = " " ;
                if (tokens[2].equalsIgnoreCase("W"))
                    bread = BreadType.WHITE.getBreadTyNl() ;
                else
                    bread = BreadType.BROWN.getBreadTyNl() ;
                String vegetable = "Nee";
                if (tokens[3].equalsIgnoreCase("Y"))
                    vegetable = "Ja" ;
                System.out.println(tokens[0] + " ".repeat(20 - tokens[0].length()) +
                        tokens[1] + " ".repeat(20 - tokens[1].length()) +
                        bread + " ".repeat(10 - bread.length())
                        + vegetable);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveOrdersInHistory () throws IOException {
        // save orders of the day in the history and create empty file for tomorrow
        Path path = Paths.get(fileLocation);
        Path path1 = Paths.get(historyFileLocation) ;
        LocalDate loc = LocalDate.now();
        try (
                BufferedReader br = Files.newBufferedReader(path);
                BufferedWriter bw = Files.newBufferedWriter(Paths.get(historyFileLocation),
                        StandardCharsets.UTF_8, StandardOpenOption.APPEND)   )
        {
            //      skip title line
            String currentLine = null ;
            br.readLine();
            while ((currentLine = br.readLine()) != null) {
                bw.newLine();
                System.out.println(currentLine);
                bw.write(loc + ";" + currentLine);
            }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            }



}
