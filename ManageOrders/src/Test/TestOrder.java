package Test;

import Exception.TooManySandwichesException;
import Model.Order;
import Model.Sandwich;
import Repository.OrderRepository;
import Repository.SandwichRepository;

import java.util.List;

public class TestOrder {
    public static void main(String[] args) {
        SandwichRepository sl = new SandwichRepository();
        List<Sandwich> sandwiches = sl.getSandwichList();
        System.out.println("sandwich of the day " + sandwiches.get(2).getSandwichName());
        OrderRepository ol = new OrderRepository() ;

        try {
            ol.addOrder(new Order( null, sandwiches.get(1), "W", null));
            ol.addOrder(new Order( null, sandwiches.get(2), "G", null));
            ol.addOrder(new Order( null, sandwiches.get(4), "W", null));
            ol.addOrder(new Order(null, sandwiches.get(0), "G", null));
            ol.addOrder(new Order( null, sandwiches.get(0), "G", null));
        } catch (TooManySandwichesException e) {
            System.out.println(e);
        }
        ol.printOrdersList();
    }
}
