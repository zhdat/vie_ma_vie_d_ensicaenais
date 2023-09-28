package fr.ensicaen.ecole.genielogiciel.model.origin;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class BachelorOrigin extends Origin{

    private final int INFO_TILE_EFFECT_BACHELOR = +1;
    private final int MATH_TILE_EFFECT_BACHELOR = -1;



    @Override
    public int getEffectOnMathsTile() {
        return MATH_TILE_EFFECT_BACHELOR;
    }

    @Override
    public int getEffectOnInfoTile() {
        return INFO_TILE_EFFECT_BACHELOR;
    }
}
