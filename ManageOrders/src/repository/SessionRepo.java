package repository;

import model.Instructor;
import model.Session;

import java.util.*;

public class SessionRepo {

    public List<Session> sessions = new ArrayList<>();
    public List<Instructor> instructors = new ArrayList<>();
    public List<String> sessionList = new ArrayList<>();

    public SessionRepo(List<Session> sessions) {
        this.sessions.addAll(sessions);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "SessionRepo{" +
                "sessions=" + sessions +
                '}';
    }

}
