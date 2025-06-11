package model;

public class Instructor extends Person {
    public Instructor(String personName) {
        super(personName);
    }

    @Override
    public String toString() {
        return "Instructor{}" + personName;
    }
}
