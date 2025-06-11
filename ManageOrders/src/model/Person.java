package model;

import java.util.Objects;

public class Person {

    public String personName ;


    public Person(String personName) {
        this.personName = personName;
    }

    public Person() {

    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                '}';
    }

    public String printName () {
        return personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(personName, person.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(personName);
    }
}
