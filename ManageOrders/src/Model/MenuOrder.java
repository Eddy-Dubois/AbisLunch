package model;

import java.time.LocalDate;

public class MenuOrder {

    private MenuItem menuItem;
    private LocalDate orderDate;
    private Person person;
    private Session session;
    double price;

    public MenuOrder(MenuItem menuItem, LocalDate orderDate, Person person, Session session , double price) {
        this.menuItem = menuItem;
        this.orderDate = orderDate;
        this.person = person;
        this.session = session;
        this.price = price;
    }


    public MenuItem getSandwich() {
        return menuItem;
    }

    public void setSandwich(MenuItem menuItem) {
        this.menuItem = menuItem;
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
