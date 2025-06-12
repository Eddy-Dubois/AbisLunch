package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuOrder {

    private Sandwich sandwich;
    private LocalDate orderDate;
    private Person person;
    private Session session;
    double price;

    public MenuOrder(Sandwich sandwich, LocalDate orderDate, Person person, Session session , double price) {
        this.sandwich = sandwich;
        this.orderDate = orderDate;
        this.person = person;
        this.session = session;
        this.price = price;
    }


    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuOrder() {

    }
}
