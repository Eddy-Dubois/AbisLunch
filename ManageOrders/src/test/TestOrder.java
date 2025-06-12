package test;

import exception.TooManySandwichesException;
import model.*;
import repository.OrderRepository;
import repository.SandwichRepository;

import java.util.List;

public class TestOrder {
    public static void main(String[] args) {
        Student s1 = new Student("Eddy");
        Student s2 = new Student("Philippe");
        Instructor i3 = new Instructor("Sandy");
        SandwichRepository sl = new SandwichRepository();
        List<model.Sandwich> sandwiches = sl.getSandwichList();
        OrderRepository ol = new OrderRepository() ;
        sl.printSandwichList();

        try {
            ol.addOrder(new Order( s1, sandwiches.get(1), "W", "Y", null));
            ol.addOrder(new Order( s2, sandwiches.get(2), "G", "N", null));
            ol.addOrder(new Order( i3, sandwiches.get(4), "W", "Y", null));
            ol.addOrder(new Order(s1, sandwiches.get(0), "G", "N", null));
            ol.addOrder(new Order( s1, sandwiches.get(0), "G", "Y", null));
        } catch (TooManySandwichesException e) {
            System.out.println(e);
        }
        ol.printOrdersList();
    }
}
