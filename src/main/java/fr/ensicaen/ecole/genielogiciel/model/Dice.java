package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Random;
public class Dice {
    private static final int MIN_FACE = 1; // FIXME FACE -> SIZE ?
    private static final int MAX_FACE = 6;

    public int roll(){
        Random rand = new Random(); // FIXME il ne fait recréer une instance de Radom à chaque landcement.
        return rand.nextInt(MAX_FACE - MIN_FACE + 1) + MIN_FACE;
    }
}
