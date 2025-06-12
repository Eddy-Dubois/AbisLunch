package model;

import java.time.LocalDate;

public class Order {
    private LocalDate orderDate;
    private Person person;
    private model.Sandwich sandwich;
    private String vegetablechoice ;
    private String bread ;
    private model.Session session;

    public String getVegetablechoice() {
        return vegetablechoice;
    }

    public void setVegetablechoice(String vegetablechoice) {
        this.vegetablechoice = vegetablechoice;
    }

    public Order(Person person, model.Sandwich sandwich, String bread, String vegetablechoice, Session session) {
        this.orderDate = LocalDate.now();
        this.person = person;
        this.sandwich = sandwich;
        this.bread = bread;
        this.vegetablechoice = vegetablechoice ;
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

    public model.Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(model.Sandwich sandwich) {
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
