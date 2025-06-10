package Repository;

import Exception.TooManySandwichesException;
import Model.Order;


import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    final int maxSandwich = 2 ;
    private int sandwichCount = 0 ;
    private List<Order> ordersList = new ArrayList<Order>();

    public OrderRepository() {
        System.out.println("creating orders");


    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Order> ordersList) {
        this.ordersList = ordersList;
    }

    public void addOrder(Order order) throws TooManySandwichesException {
    // check maximum of sandwich
        int orderOfDay = countSandwichOfPerson(order.getPerson()) ;
        System.out.println("actual Sandwiches for " + order.getPerson() + " is " + orderOfDay);
        if (orderOfDay > maxSandwich)
            throw new TooManySandwichesException("sandwich refused for " + order.getPerson());
        else
        ordersList.add(order);
    }

    public int countSandwichOfPerson (String name) {
        ordersList.stream()
                .filter(order -> order.getPerson().equalsIgnoreCase(name))
                .count();
        return sandwichCount ;
    }

    public void printOrdersList() {
        for (Order order : ordersList) {
            System.out.println(order.getOrderDate() + " " + order.getPerson() + " " + order.getSandwich().getSandwichName());
        }
    }
}
