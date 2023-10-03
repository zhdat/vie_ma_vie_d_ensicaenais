package fr.ensicaen.ecole.genielogiciel.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceTest {

    @Test
    void rollTest() {
        Dice d = new Dice();
        int result = d.roll();
        System.out.println(result);
        assertTrue(result > 0 && result < 7);
    }
}