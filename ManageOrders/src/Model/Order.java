package Model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private LocalDate orderDate;
    private Person person;
    private Sandwich sandwich;
    private String bread ;
    private Session session;

    public Order(Person person, Sandwich sandwich, String bread, Session session) {
        this.orderDate = LocalDate.now();
        this.person = person;
        this.sandwich = sandwich;
        this.bread = bread;
        this.session = session;
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

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
