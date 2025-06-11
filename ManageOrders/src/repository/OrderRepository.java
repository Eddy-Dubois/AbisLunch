package repository;

import exception.TooManySandwichesException;
import model.Order;
import model.Sandwich;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    static String fileLocation = "C:/temp/javacourses/orderoftheday.txt";
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
        int orderOfDay = countSandwichOfPerson(order.getPerson().getPersonName()) ;
        if (orderOfDay >= maxSandwich)
            throw new TooManySandwichesException("sandwich refused for " + order.getPerson());
        else
            ordersList.add(order);
            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND)){
                bw.newLine();
                bw.append(formatOrder(order));
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }

    }

    public int countSandwichOfPerson (String name) {
        int sandwichCount = (int) ordersList.stream()
                .filter(order -> order.getPerson().getPersonName().equalsIgnoreCase(name))
                .count();
        return sandwichCount ;
    }

    public void proposeMenu () {
    }

    public String formatOrder(Order order) {
        StringBuilder stringBuilder = new StringBuilder(order.getPerson().personName);
        stringBuilder.append(";");
        stringBuilder.append(order.getSandwich().getSandwichName());
        stringBuilder.append(";");
        stringBuilder.append(order.getBread());
        stringBuilder.append(";");
        stringBuilder.append(order.getVegetablechoice());
        stringBuilder.append(";");
        ;
        return stringBuilder.toString() ;
    }

    public void printOrdersList() {
        for (Order order : ordersList) {
            System.out.println(order.getOrderDate() + " " + order.getPerson().getPersonName() + " " +
                    order.getSandwich().getSandwichName() + " " + order.getSandwich().getSandwichPrice()); ;
        }
    }
}
