package test;

import repository.ManagerRepository;

import java.io.IOException;

public class TestManager {
    public static void main(String[] args) throws IOException {
        ManagerRepository ml = new ManagerRepository() ;
        ml.printOrdersOfTheDay();
        System.out.println("***** history *****");
        ml.saveOrdersInHistory();
    }
}
