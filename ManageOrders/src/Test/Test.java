package Test;

import Utils.*;
import exceptions.UserNotFoundException;
import model.*;
import repository.OrderRepository;
import repository.SandwichRepository;
import repository.SessionRepo;
import services.AccountantRolesImpl;
import services.GeneralManagerRolesImpl;
import services.ManagerRolesImpl;
import services.PersonRolesImpl;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, UserNotFoundException {

        SessionRepo sessionRepo = new SessionRepo();
        Set<Student> studentList = sessionRepo.getStudents();
        Set<Instructor> instructorList = sessionRepo.getInstructors();

        List<Session> sessionList = sessionRepo.getSessions();
        Map<String , List<Student>> studentMap = sessionRepo.getSessionNameToStudents();
        Map<String, Instructor> instructorMap = sessionRepo.getSessionNameToInstructor();
        SandwichRepository sandwichRepository = new SandwichRepository();
        List<Sandwich> sandwichList = sandwichRepository.getSandwiches();
        Map<String , List<Ingredients>> ingredientsMap = sandwichRepository.getSandwichToIngredients();
        List<Sandwich> sandwichConfirmed = new ArrayList<>();
        PersonRolesImpl personRoles = new PersonRolesImpl();
        OrderRepository oR = new OrderRepository() ;
        Person person = new Person() ;
        Session sessionSel ;
        int role = PrintLoginPage.printLogin();
        String choice = ListOptions.printList(role);
        if (role == 1 || role == 2 || (role == 4 && (Integer.parseInt(choice) == 1)) ) {
            person = PrepareData.mapData(role , studentList , instructorList);
            sandwichConfirmed = PrintMenu.listMenu(sandwichRepository);
            final Person personfound = person;
            Optional<Session> session;
            for (Sandwich s : sandwichConfirmed) {
                if (person instanceof Student) {
                    String sessionName = studentMap.entrySet().stream()
                            .filter(entry -> entry.getValue().contains(personfound)) // Find matching student
                            .map(Map.Entry::getKey) // Extract session name
                            .findFirst()
                            .orElse("Session not found");
                    session = Optional.ofNullable(sessionList.stream()
                            .filter(ses -> ses.getSessionName().equalsIgnoreCase(sessionName))
                            .findFirst()
                            .orElseThrow(() -> new NoSuchElementException("Session not found")));
                    sessionSel = session.get();
                    MenuOrder order = new MenuOrder(s,LocalDate.now() , person , sessionSel, s.getPrice()  ) ;
                    personRoles.addOrder(order);

                } else if (person instanceof Instructor) {
                    String sessionName = instructorMap.entrySet().stream()
                            .filter(entry -> entry.getValue().equals(personfound)) // Find matching Instructor
                            .map(Map.Entry::getKey) // Extract session name
                            .findFirst()
                            .orElse("Session not found");
                    session = Optional.ofNullable(sessionList.stream()
                            .filter(ses1 -> ses1.getSessionName().equalsIgnoreCase(sessionName))
                            .findFirst()
                            .orElseThrow(() -> new NoSuchElementException("Session not found")));
                    sessionSel = session.get();
                    MenuOrder order = new MenuOrder(s,LocalDate.now() , person , sessionSel, s.getPrice()  ) ;
                    oR.setOrderList(personRoles.addOrder(order));
                }
            }
        }
        if (role == 3) {
            AccountantRolesImpl accountantRoles = new AccountantRolesImpl();
            accountantRoles.calculateExpenses(oR.getOrderList());
        }
        if (role == 4) {
            ManagerRolesImpl managerRoles = new ManagerRolesImpl();
            switch (Integer.parseInt(choice)) {
                case 2:
                       PrintOrdersList.printConfirmedOrders(oR.getOrderList());
                       System.out.println("Authenticate Person whose order needs to be removed");
                       Scanner sc = new Scanner(System.in) ;
                       Person p1 = new Student(sc.nextLine());
                       managerRoles.removeOrder(oR.getOrderList() , p1);
                case 3:
                    managerRoles.printOrders(oR.getOrderList());
            }
        }
        if (role == 5) {
            GeneralManagerRolesImpl generalManagerRoles = new GeneralManagerRolesImpl();
            generalManagerRoles.viewStats(oR.getOrderList());
        }
    }
}
