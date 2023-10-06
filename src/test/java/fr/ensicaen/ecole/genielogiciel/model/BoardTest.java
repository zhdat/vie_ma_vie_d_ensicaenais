package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.board.Board;
import fr.ensicaen.ecole.genielogiciel.model.board.ClassicBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testGetHolidaysPositions() {
        Board board = new ClassicBoard();
        int[] expectedHolidaysPositions = {27, 35};

        int[] holidaysPositions = board.getHolidaysPositions();

        assertArrayEquals(expectedHolidaysPositions, holidaysPositions);
    }

    @Test
    public void testGetExamsPositions() {
        Board board = new ClassicBoard();
        int[] expectedExamsPositions = {21, 42, 64};

        int[] examsPositions = board.getExamsPositions();

        assertArrayEquals(expectedExamsPositions, examsPositions);
    }

    @Test
    public void testGetNewYearsPositions() {
        Board board = new ClassicBoard();
        int[] expectedNewYearsPositions = {0, 22, 43};

        int[] newYearsPositions = board.get_newYearsPositions();

        assertArrayEquals(expectedNewYearsPositions, newYearsPositions);
    }

    @Test
    public void testGetNumberOfTiles() {
        Board board = new ClassicBoard();
        int expectedNumberOfTiles = 65;

        int numberOfTiles = board.getNumberOfTiles();

        assertEquals(expectedNumberOfTiles, numberOfTiles);
    }
}

