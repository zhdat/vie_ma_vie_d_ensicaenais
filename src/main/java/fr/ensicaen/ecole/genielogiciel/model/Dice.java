package fr.ensicaen.ecole.genielogiciel.model;

import java.util.Random;

public class Dice {
    private Random _r = new Random();
    public int roll(int numberOfDies) {
        int ret = 0;
        for (int i = 0; i < numberOfDies ; i++) {
            ret += _r.nextInt(6) + 1;
        }
        return ret;
    }
}

