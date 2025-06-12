package Utils;

import model.Instructor;
import model.Person;
import model.Student;
import exceptions.UserNotFoundException;
import java.util.NoSuchElementException;

import java.util.*;

public class PrepareData {

    private static Person p;

    public static Person mapData (int role , Set<Student> students , Set<Instructor> instructors) throws UserNotFoundException {

        int i = 0 ;
        switch (role) {
            case 1:
                for (Student student : students) {
                    System.out.println(++i + ". " + student.printName());
                }break;
            case 2:
                i =0 ;
                for (Instructor instructor : instructors) {
                    System.out.println(++i + ". " + instructor.printName());
                }break;
        }
        System.out.println("-".repeat(100));

        Scanner sc = new Scanner(System.in);
        boolean found = false ;
        while (!found) {
            System.out.println("Authenticate by Name");
            System.out.println("-".repeat(100));

            if (sc.hasNextLine()) {
                final String inputName = sc.nextLine();
                switch (role){
                    case 1:
                        try {
                            Student student = students.stream()
                                    .filter(s -> s.getPersonName().equalsIgnoreCase(inputName))
                                    .findFirst()
                                    .orElseThrow(() -> new NoSuchElementException("Not a valid User. Try Again!!!"));
                            found = true;
                            p = student ;
                        } catch (NoSuchElementException e ) {
                            System.out.println(e.getMessage());
                            found = false;
                        }  break;
                    case 2:
                        try {
                            Instructor instructor = instructors.stream()
                                    .filter(s -> s.getPersonName().equalsIgnoreCase(inputName))
                                    .findFirst()
                                    .orElseThrow(() -> new UserNotFoundException("Not a valid User"));
                            found = true;
                            p = instructor;
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        } found = false; break;
                }
                System.out.println(found ? "Welcome " + inputName.substring(0,1).toUpperCase()
                        + inputName.substring(1).toLowerCase(): "User Not Found");
                System.out.println("-".repeat(100));

            } else {
                System.out.println("Waiting for Input!!!");
            }

        }return p;
    }
}
