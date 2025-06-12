package test;

import exception.SandwichAlreadyExistException;
import model.Sandwich;
import repository.SandwichRepository;

import java.util.List;

public class TestSandwich {

    public static void main(String[] args) {
        SandwichRepository sl = new SandwichRepository();
        List<model.Sandwich> sandwiches = sl.getSandwichList();
        System.out.println("***** adding Crevettes");
        model.Sandwich s1 = new model.Sandwich("Salade de crevettes", "Fish", "Salade de crevettes", true, 8.5);

        try {
            sl.addSandwich(s1);
            sl.addSandwich(s1);
        } catch (SandwichAlreadyExistException e) {
            System.out.println(e);
        }

        sl.printSandwichList();
        System.out.println("***** removing 3");
        sl.removeSandwich("Rosbif");
        sl.printSandwichList();
    }
}
