package repository;

import model.MenuItem;

import java.util.List;

public class SandwichRepo {

    public List<MenuItem> sandwiches;

    public SandwichRepo(List<MenuItem> sandwiches) {
        this.sandwiches.addAll(sandwiches);
    }
}
