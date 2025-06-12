package model;

public class Student extends Person{

    public Student(String personName) {
        super(personName);
    }

    @Override
    public String toString() {
        return "Student{}" + personName;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
