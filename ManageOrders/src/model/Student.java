package model;

public class Student extends Person{

    public Student(String personName) {
        super(personName);
    }

    @Override
    public String toString() {
        return "Student{}" + personName;
    }


}
