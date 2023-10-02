package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Random;
public class Dice {
    private static final int MIN_FACE = 1;
    private static final int MAX_FACE = 6;

    public int lancerDe(){
        Random rand = new Random();
        return rand.nextInt(MAX_FACE - MIN_FACE + 1) + MIN_FACE;
    }
}
