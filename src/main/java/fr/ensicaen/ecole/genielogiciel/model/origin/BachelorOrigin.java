package fr.ensicaen.ecole.genielogiciel.model.origin;

public class BachelorOrigin implements Origin{
    @Override
    public int getEffectOnMathsTile() {
        return -1;
    }

    @Override
    public int getEffectOnInfoTile() {
        return 1;
    }
}
