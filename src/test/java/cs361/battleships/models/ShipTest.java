package cs361.battleships.models;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class ShipTest {
    @Test
    public void testNewShip_Valid_MINESWEEPER() {
        Ship minesweeper = new Ship("MINESWEEPER");
    }

    @Test
    public void testNewShip_Valid_DESTROYER() {
        Ship destroyer = new Ship("DESTROYER");
    }

    @Test
    public void testNewShip_Valid_BATTLESHIP() {
        Ship battleship = new Ship("BATTLESHIP");
    }

    @Test
    public void testNewShip_Invalid() {
        Ship bad = new Ship("blorp");
    }

    @Test
    public void testNewShip_DefaultConstructor() {
        Ship empty = new Ship();
    }

    @Test
    public void testGetOccupiedSquares_BlankList_DefaultConstructor(){
        Ship empty = new Ship();
        assertTrue(empty.getOccupiedSquares().isEmpty());
    }

    @Test
    public void testGetOccupiedSquares_BlankList_StringConstructor(){
        Ship minesweeper = new Ship("MINESWEEPER");
        assertTrue(minesweeper.getOccupiedSquares().isEmpty());
    }
}
