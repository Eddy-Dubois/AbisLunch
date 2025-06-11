package repository;

import Utils.ReadUserData;
import model.Instructor;
import model.Session;
import model.Student;

import java.io.FileNotFoundException;
import java.util.*;

public class SessionRepo {

    private List<Session> sessions = new ArrayList<>();

    private Set<Student> students =  new TreeSet<>(Comparator.comparing(Student::getPersonName));
    private Set<String> sessionNames = new HashSet<>();
    private Set<Instructor> instructors = new TreeSet<>(Comparator.comparing(Instructor::getPersonName));

    private Map<String, Instructor> sessionNameToInstructor = new HashMap<>();
    private Map<String, List<Student>> sessionNameToStudents = new HashMap<>();

    public SessionRepo() throws FileNotFoundException {
        loadUser();
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Map<String, Instructor> getSessionNameToInstructor() {
        return sessionNameToInstructor;
    }

    public Map<String, List<Student>> getSessionNameToStudents() {
        return sessionNameToStudents;
    }

    @Override
    public String toString() {
        return "SessionRepo{" +
                "sessions=" + sessions +
                '}';
    }

    private void loadUser() throws FileNotFoundException {
        List<ReadUserData> readList = ReadUserData.readInput();

        for (ReadUserData rf : readList) {
            students.add(rf.getStudent());
            sessionNames.add(rf.getSessionName());
            instructors.add(rf.getInstructor());

            sessionNameToInstructor.put(rf.getSessionName(), rf.getInstructor());

            sessionNameToStudents.computeIfAbsent(rf.getSessionName(), k -> new ArrayList<>()).add(rf.getStudent());
        }

        for (Map.Entry<String, List<Student>> entry : sessionNameToStudents.entrySet()) {
            String sessionName = entry.getKey();
            List<Student> studentList = entry.getValue();
            Instructor instructor = sessionNameToInstructor.get(sessionName);

            StudentRepo studentRepo = new StudentRepo(studentList);
            int nbrofStudents = students.size();

            Session session = new Session(sessionName, instructor, studentRepo, nbrofStudents);
            sessions.add(session);
        }
    }
}