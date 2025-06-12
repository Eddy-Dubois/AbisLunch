package test;

import exception.SandwichAlreadyExistException;
import model.Sandwich;
import org.junit.jupiter.api.Test;
import repository.SandwichRepository;

import static org.junit.jupiter.api.Assertions.*;

public class SanwichTest {

    SandwichRepository sl = new SandwichRepository();
    @Test
    public void sandwichNotExists() throws SandwichAlreadyExistException {
        Sandwich s1 = new Sandwich("Salade de crevettes", "Fish",
                "Salade de crevettes", true, 8.5);
        assertDoesNotThrow(() -> {
            sl.addSandwich(s1);
        });
    }
    @Test
    public void sandwichAlreadyExists () throws SandwichAlreadyExistException {
        Sandwich s1 = new Sandwich("Salade de saumon", "Fish", "Salade de saumon", true, 8.5);
        assertThrows(SandwichAlreadyExistException.class, ()->sl.addSandwich(s1) );
    }


}
