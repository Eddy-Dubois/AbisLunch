package test;

import Utils.*;
import enumerations.Bread;
import exception.TooManySandwichesException;
import exceptions.UserNotFoundException;
import model.*;
import repository.*;
import services.AccountantRolesImpl;
import services.GeneralManagerRolesImpl;
import services.ManagerRolesImpl;
import services.PersonRolesImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.runtime.SwitchBootstraps;
import java.time.LocalDate;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException, UserNotFoundException, TooManySandwichesException {

        SessionRepo sessionRepo = new SessionRepo();
        Set<model.Student> studentList = sessionRepo.getStudents();
        Set<model.Instructor> instructorList = sessionRepo.getInstructors();

        List<model.Session> sessionList = sessionRepo.getSessions();
        Map<String , List<model.Student>> studentMap = sessionRepo.getSessionNameToStudents();
        Map<String, model.Instructor> instructorMap = sessionRepo.getSessionNameToInstructor();
        SandwichRepo sandwichRepository = new SandwichRepo();
        List<MenuItem> menuItemList = sandwichRepository.getSandwiches();
        Map<String , List<Ingredients>> ingredientsMap = sandwichRepository.getSandwichToIngredients();
        List<MenuItem> menuItemConfirmed = new ArrayList<>();
        PersonRolesImpl personRoles = new PersonRolesImpl();
        ManagerRolesImpl managerRoles = new ManagerRolesImpl();
        ManagerRepository managerRepository = new ManagerRepository();
        List<MenuOrder> menuOrderList = new ArrayList<>();
        Sandwich sandwich;
        OrderRepository orderRepository  = new OrderRepository();
        OrderRepo orderRepo = new OrderRepo();
        model.Person person = new Person() ;
        model.Session sessionSel ;

        Scanner scannerin = new Scanner(System.in) ;
        String lastin = null;
        do{
        int role = PrintLoginPage.printLogin();
        person = PrepareData.mapData(role , studentList , instructorList);

        String choice = ListOptions.printList(role);
        if (role == 1 || role == 2 || (role == 4 && (Integer.parseInt(choice) == 1)) ) {

            menuItemConfirmed = PrintMenu.listMenu(sandwichRepository, ingredientsMap );
            final model.Person personfound = person;
            Optional<model.Session> session;
            for (MenuItem s : menuItemConfirmed) {
                if (person instanceof model.Student) {
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
                    model.Sandwich s1 = new model.Sandwich("Salade de crevettes", "Fish", "Salade de crevettes", true, 8.5);

                    String ingredients = ingredientsMap.entrySet().stream()
                            .filter(entry -> entry.getValue().contains(s.getName())) // Find matching Instructor
                            .map(Map.Entry::getKey) // Extract session name
                            .findFirst()
                            .orElse("Ingredient not found");


                    String bread ;
                    if (s.getBreadType() == Bread.GRIS) {
                        bread = "B" ;
                    } else {
                        bread = "W" ;
                    }
                    String veggie = "N";
                    if (s.isHasVeggies()){
                        veggie = "Y" ;
                    }
                    String category = null ;
                    switch (s.getType()) {
                        case VLEES :  category = "Viandes"; break;
                        case KAAS: category = "Cheese" ;break;
                        case VIS: category = "Fish" ;break;
                        case SPECIALS: category = "Specials" ;break;
                        case VEGETARISCHE: category = "Veggie" ;break;
                    }
                    sandwich = new Sandwich(s.getName(),category , ingredients , s.isHasVeggies() , s.getPrice());
                    String breadtype ;
                    Order order = new Order(person , sandwich , bread , veggie , null ) ;
                    MenuOrder menuOrder = new MenuOrder(s,LocalDate.now() , person , sessionSel, s.getPrice()  ) ;
                    orderRepository.addOrder(order);
                    orderRepo.setOrderList(personRoles.addOrderMenu(menuOrder));

                } else if (person instanceof model.Instructor) {
                    String sessionName = instructorMap.entrySet().stream()
                            .filter(entry -> entry.getValue().equals(personfound)) // Find matching Instructor
                            .map(Map.Entry::getKey) // Extract session name
                            .findFirst()
                            .orElse("Session not found");
                    session = Optional.ofNullable(sessionList.stream()
                            .filter(ses1 -> ses1.getSessionName().equalsIgnoreCase(sessionName))
                            .findFirst()
                            .orElseThrow(() -> new NoSuchElementException("Session not found")));

                    String ingredients = ingredientsMap.entrySet().stream()
                            .filter(entry -> entry.getValue().contains(s.getName())) // Find matching Instructor
                            .map(Map.Entry::getKey) // Extract session name
                            .findFirst()
                            .orElse("Ingredient not found");

                    sessionSel = session.get();
                    MenuOrder menuOrder = new MenuOrder(s,LocalDate.now() , person , sessionSel, s.getPrice()  ) ;
                    String bread ;
                    if (s.getBreadType() == Bread.GRIS) {
                        bread = "B" ;
                    } else {
                        bread = "W" ;
                    }
                    String veggie = "N";
                    if (s.isHasVeggies()){
                        veggie = "Y" ;
                    }
                    String category = null ;
                    switch (s.getType()) {
                        case VLEES :  category = "Viandes"; break;
                        case KAAS: category = "Cheese" ;break;
                        case VIS: category = "Fish" ;break;
                        case SPECIALS: category = "Specials" ;break;
                        case VEGETARISCHE: category = "Veggie" ;break;
                    }

                    sandwich = new Sandwich(s.getName(),category , ingredients , s.isHasVeggies() , s.getPrice());
                    String breadtype ;
                    Order order = new Order(person , sandwich , bread , veggie , null ) ;
                    menuOrder = new MenuOrder(s,LocalDate.now() , person , sessionSel, s.getPrice()  ) ;
                    orderRepository.addOrder(order);
                    orderRepo.setOrderList(personRoles.addOrderMenu(menuOrder)) ;
                    menuOrderList = orderRepo.getOrderList();
                    menuOrderList.stream()
                            .forEach(System.out::println);
                }
            }
        }
        if (role == 3) {
            AccountantRolesImpl accountantRoles = new AccountantRolesImpl();
            accountantRoles.calculateExpenses(orderRepo.getOrderList());
        }
        if (role == 4) {

            switch (Integer.parseInt(choice)) {
                 case 2:
                       PrintOrdersList.printConfirmedOrders(orderRepo.getOrderList());
                       System.out.println("Authenticate Person whose order needs to be removed");
                       Scanner sc = new Scanner(System.in) ;
                       Person p1 = new Person(sc.nextLine());
                       managerRoles.removeOrder(orderRepo.getOrderList() , p1);
                       break;
                case 3:
                    managerRepository.printOrdersOfTheDay();
                    managerRoles.printOrders(orderRepo.getOrderList());
                    break;
                case 4:
                    managerRepository.saveOrdersInHistory();
            }
        }
        if (role == 5) {
            GeneralManagerRolesImpl generalManagerRoles = new GeneralManagerRolesImpl();
            generalManagerRoles.viewStats(orderRepo.getOrderList());
        }
            System.out.print("Continue ?? ");
            lastin = scannerin.nextLine();
        }  while (lastin.equalsIgnoreCase("Y")) ;
    }
}
