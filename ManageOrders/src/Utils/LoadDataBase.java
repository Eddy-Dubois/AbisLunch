package Utils;

import model.*;
import repository.IngredientRepo;
import repository.SandwichRepository;
import repository.SessionRepo;
import repository.StudentRepo;

import java.io.FileNotFoundException;
import java.util.*;

public class LoadDataBase {
    public static Set<Student> students =  new TreeSet<>(Comparator.comparing(Student::getPersonName));
    static Set<String> sessionNames = new HashSet<>();
    public static Set<Instructor> instructors = new TreeSet<>(Comparator.comparing(Instructor::getPersonName));

    public static Map<String, Instructor> sessionNameToInstructor = new HashMap<>();
    public static Map<String, List<Student>> sessionNameToStudents = new HashMap<>();

    public static Set<Sandwich> sandwiches =  new TreeSet<>(Comparator.comparing(Sandwich::getName));
    public static Set<Ingredients> ingredients = new TreeSet<>(Comparator.comparing(Ingredients::getIngredient));
    public static Map<String, List<Ingredients>> sandwichToIngredients = new HashMap<>();


    public static void loadAllData () throws FileNotFoundException {
        List<ReadUserData> readList = ReadUserData.readInput();

        for (ReadUserData rf : readList) {
            students.add(rf.getStudent());
            sessionNames.add(rf.getSessionName());
            instructors.add(rf.getInstructor());

            sessionNameToInstructor.put(rf.getSessionName(), rf.getInstructor());

            sessionNameToStudents.computeIfAbsent(rf.getSessionName(), k -> new ArrayList<>()).add(rf.getStudent());
        }
        List<Session> sessions = new ArrayList<>();

        for (Map.Entry<String, List<Student>> entry : sessionNameToStudents.entrySet()) {
            String sessionName = entry.getKey();
            List<Student> studentList = entry.getValue();
            Instructor instructor = sessionNameToInstructor.get(sessionName);

            StudentRepo studentRepo = new StudentRepo(studentList);
            int nbrofStudents = students.size();

            Session session = new Session(sessionName, instructor, studentRepo, nbrofStudents);
            sessions.add(session);
        }
        SessionRepo sessionRepo = new SessionRepo(sessions) ;

        List<ReadBasicMenu> readMenu = ReadBasicMenu.readInput();
        List <Sandwich> sandwichList = new ArrayList<>();
        for (ReadBasicMenu rm : readMenu) {
            Sandwich s = new Sandwich(rm.getSandwichName(), true, rm.getSandwichType() , rm.getPrice()) ;
            sandwiches.add(s);
        }

        List<ReadSpecials> readSpecials = ReadSpecials.readInput();
        for (ReadSpecials rs : readSpecials) {
            IngredientRepo ingredientRepo = new IngredientRepo(rs.getIngredients());
            Sandwich s = new Sandwich(rs.getSandwichName(), false, rs.getSandwichType(), ingredientRepo , rs.getPrice()) ;
            sandwiches.add(s);
            sandwichToIngredients.put(s.getName(),rs.getIngredients());
        }
        sandwichList.addAll(sandwiches);
        SandwichRepository sandwichRepository = new SandwichRepository(sandwichList);
    }
}
