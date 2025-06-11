package Utils;

import model.Instructor;
import model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadUserData {

    private String sessionName;
    private Student student;
    private Instructor instructor;

    static List<ReadUserData> readFileList = new ArrayList<>();

    public ReadUserData(String sessionName, Student student, Instructor instructor) {
        this.sessionName = sessionName;
        this.student = student;
        this.instructor = instructor;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public static List<ReadUserData> readInput() throws FileNotFoundException {
        String path = "StudentList";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                ReadUserData r = parseLine(line);
                readFileList.add(r);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return readFileList;
    }
    public static ReadUserData parseLine(String s) {
        String[] parts = s.split(";");
        return new ReadUserData(String.valueOf(parts[0]) , new Student(parts[1]), new Instructor(parts[2])) ;
    }

    @Override
    public String toString() {
        return "ReadFile{" +
                "sessionName='" + sessionName + '\'' +
                ", student=" + student +
                ", instructor=" + instructor +
                '}';
    }
}
