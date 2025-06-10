package Model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private String orderDate;
//    private Person person;
    String person ;
    private Sandwich sandwich;
    private String bread ;
    private Session session;

    public Order(Person person, Sandwich sandwich, String bread, Session session) {
        this.orderDate = LocalDate.now().toString();
     //   this.person = person;
        if (bread == "G")
            this.person = "Eddy" ;
        else this.person = "other" ;
        this.sandwich = sandwich;
        this.bread = bread;
        this.session = session;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPerson() {
  //  public Person getPerson() {
        return person;
    }

    public void setPerson(String person) {
  //  public void setPerson(Person person) {
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
