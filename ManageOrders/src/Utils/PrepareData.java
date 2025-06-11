package Utils;

import model.Instructor;
import model.Session;
import model.Student;
import exceptions.UserNotFoundException;
import java.util.NoSuchElementException;
import repository.SessionRepo;
import repository.StudentRepo;

import java.util.*;

import static Utils.LoadDataBase.*;

public class PrepareData {

    public static void mapData (int role) throws UserNotFoundException {

/*        List<Session> sessions = new ArrayList<>();

        for (Map.Entry<String, List<Student>> entry : sessionNameToStudents.entrySet()) {
            String courseName = entry.getKey();
            List<Student> studentList = entry.getValue();
            Instructor instructor = sessionNameToInstructor.get(courseName);

            StudentRepo studentRepo = new StudentRepo(studentList);
            int nbrofStudents = students.size();

            Session session = new Session(courseName, instructor, studentRepo, nbrofStudents);
            sessions.add(session);
        }
        SessionRepo sessionRepo = new SessionRepo(sessions) ; */
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
            if (sc.hasNextLine()) {
                final String inputName = sc.nextLine();
                switch (role){
                    case 1:
                        try {
                            Student student = students.stream()
                                    .filter(s -> s.getPersonName().equalsIgnoreCase(inputName))
                                    .findFirst()
                                    .orElseThrow(() -> new NoSuchElementException("Not a valid User"));
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        } found = true ; break;
                    case 2:
                        try {
                            Instructor instructor = instructors.stream()
                                    .filter(s -> s.getPersonName().equalsIgnoreCase(inputName))
                                    .findFirst()
                                    .orElseThrow(() -> new UserNotFoundException("Not a valid User"));
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        } found = true; break;
                }
                System.out.println(found ? "Welcome " + inputName.substring(0,1).toUpperCase()
                        + inputName.substring(1).toLowerCase(): "User Not Found");
            } else {
                System.out.println("Waiting for Input!!!");
            }
        }
    }
}
