package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Random;
public class Dice {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;
    Random rand = new Random();
    public int roll(){

        return rand.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
    }
}
