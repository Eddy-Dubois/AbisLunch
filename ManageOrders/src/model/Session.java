package model;

import repository.StudentRepo;

public class Session {
    private String sessionName;
    private Instructor instructor;
    private StudentRepo studentRepo;
    private int nbrofStudents;

    public Session(String sessionName, Instructor instructor, StudentRepo studentRepo, int nbrofStudents) {
        this.sessionName = sessionName;
        this.instructor = instructor;
        this.studentRepo = studentRepo;
        this.nbrofStudents = nbrofStudents;
    }

    public String getSessionName() {
        return sessionName;
    }

    public int getNbrofStudents() {
        return nbrofStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public String toString() {
        return "Session{" +
                "instructor=" + instructor +
                ", studentRepo=" + studentRepo +
                '}';
    }
}
