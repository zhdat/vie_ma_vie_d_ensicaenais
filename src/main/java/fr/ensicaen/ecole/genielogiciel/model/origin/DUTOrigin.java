package fr.ensicaen.ecole.genielogiciel.model.origin;

public class DUTOrigin implements Origin{
    @Override
    public int getEffectOnInfoTile() {
        return 1;
    }

    @Override
    public int getEffectOnMathsTile() {
        return -1;
    }
}
