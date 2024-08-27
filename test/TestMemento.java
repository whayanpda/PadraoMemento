import static org.junit.jupiter.api.Assertions.*;

import org.example.CareTaker;
import org.example.Originator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMemento {

        private Originator originator;
        private CareTaker careTaker;

        @BeforeEach
        public void setUp() {
            originator = new Originator();
            careTaker = new CareTaker(originator);
        }

        @Test
        public void testSaveState() {

            originator.moveLeft();
            originator.moveRight();
            originator.moveLeft();
            careTaker.saveState();

            assertEquals("<--><-", originator.getState());
        }

    @Test
    public void testRestoreState() {
        originator.moveLeft();
        careTaker.saveState();

        originator.moveLeft();
        originator.moveRight();
        originator.moveLeft();
        careTaker.saveState();

        originator.moveLeft();
        originator.moveRight();
        originator.moveLeft();
        careTaker.saveState();

        careTaker.undo();
        assertEquals("<-<--><-<--><-", originator.getState());
        careTaker.undo();
        assertEquals("<-<--><-", originator.getState());
        careTaker.undo();
        assertEquals("<-", originator.getState());
    }

    }