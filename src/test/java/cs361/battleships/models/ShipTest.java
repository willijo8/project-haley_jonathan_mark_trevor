package cs361.battleships.models;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
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

    @Test
    public void testSetOccupiedSquares_MINESWEEPER_Vertical(){
        Ship minesweeper = new Ship("MINESWEEPER");
        minesweeper.setOccupiedSquares(2,'B',true);
        assertEquals(minesweeper.getOccupiedSquares().get(0).getColumn(),'B');
        assertEquals(minesweeper.getOccupiedSquares().get(0).getRow(),2);
        assertEquals(minesweeper.getOccupiedSquares().get(1).getColumn(),'B');
        assertEquals(minesweeper.getOccupiedSquares().get(1).getRow(),3);
        assertEquals(minesweeper.getOccupiedSquares().size(),2);
    }

    @Test
    public void testSetOccupiedSquares_MINESWEEPER_Horizontal(){
        Ship minesweeper = new Ship("MINESWEEPER");
        minesweeper.setOccupiedSquares(2,'B',false);
        assertEquals(minesweeper.getOccupiedSquares().get(0).getColumn(),'B');
        assertEquals(minesweeper.getOccupiedSquares().get(0).getRow(),2);
        assertEquals(minesweeper.getOccupiedSquares().get(1).getColumn(),'C');
        assertEquals(minesweeper.getOccupiedSquares().get(1).getRow(),2);
        assertEquals(minesweeper.getOccupiedSquares().size(),2);
    }

    @Test
    public void testSetOccupiedSquares_DESTROYER_Vertical(){
        Ship destroyer = new Ship("DESTROYER");
        destroyer.setOccupiedSquares(2,'B',true);
        assertEquals(destroyer.getOccupiedSquares().get(0).getColumn(),'B');
        assertEquals(destroyer.getOccupiedSquares().get(0).getRow(),2);
        assertEquals(destroyer.getOccupiedSquares().get(2).getColumn(),'B');
        assertEquals(destroyer.getOccupiedSquares().get(2).getRow(),4);
        assertEquals(destroyer.getOccupiedSquares().size(),3);
    }

    @Test
    public void testSetOccupiedSquares_DESTROYER_Horizontal(){
        Ship destroyer = new Ship("DESTROYER");
        destroyer.setOccupiedSquares(2,'B',false);
        assertEquals(destroyer.getOccupiedSquares().get(0).getColumn(),'B');
        assertEquals(destroyer.getOccupiedSquares().get(0).getRow(),2);
        assertEquals(destroyer.getOccupiedSquares().get(2).getColumn(),'D');
        assertEquals(destroyer.getOccupiedSquares().get(2).getRow(),2);
        assertEquals(destroyer.getOccupiedSquares().size(),3);
    }

    @Test
    public void testSetOccupiedSquares_BATTLESHIP_Vertical(){
        Ship battleship = new Ship("BATTLESHIP");
        battleship.setOccupiedSquares(2,'B',true);
        assertEquals(battleship.getOccupiedSquares().get(0).getColumn(),'B');
        assertEquals(battleship.getOccupiedSquares().get(0).getRow(),2);
        assertEquals(battleship.getOccupiedSquares().get(3).getColumn(),'B');
        assertEquals(battleship.getOccupiedSquares().get(3).getRow(),5);
        assertEquals(battleship.getOccupiedSquares().size(),4);
    }

    @Test
    public void testSetOccupiedSquares_BATTLESHIP_Horizontal(){
        Ship battleship = new Ship("BATTLESHIP");
        battleship.setOccupiedSquares(2,'B',false);
        assertEquals(battleship.getOccupiedSquares().get(0).getColumn(),'B');
        assertEquals(battleship.getOccupiedSquares().get(0).getRow(),2);
        assertEquals(battleship.getOccupiedSquares().get(3).getColumn(),'E');
        assertEquals(battleship.getOccupiedSquares().get(3).getRow(),2);
        assertEquals(battleship.getOccupiedSquares().size(),4);
    }

    @Test
    public void testSetOccupiedSquares_BlankShip(){
        Ship empty = new Ship();
        empty.setOccupiedSquares(2,'B',false);
        assertTrue(empty.getOccupiedSquares().isEmpty());
    }
}
