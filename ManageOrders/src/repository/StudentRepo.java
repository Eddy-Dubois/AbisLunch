package repository;

import model.Person;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo {

    private List<Student> studentList = new ArrayList<>();

    public StudentRepo(List<Student> students) {
        this.studentList.addAll(students);
    }

    public List<Student> getStudentList() {
        return studentList;
    }


    @Override
    public String toString() {
        return "StudentRepo{" +
                "studentList=" + studentList +
                '}';
    }


}
