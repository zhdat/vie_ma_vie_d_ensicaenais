package fr.ensicaen.ecole.genielogiciel.model.origin;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class DUTOrigin extends Origin{

    private final int INFO_TILE_EFFECT_DUT = +1;
    private final int MATH_TILE_EFFECT_DUT = -1;
    private Player _player;

    public DUTOrigin(Player p){
        _player = p;
    }

    @Override
    public int getEffectOnMathsTile() {
        return MATH_TILE_EFFECT_DUT;
    }

    @Override
    public int getEffectOnInfoTile() {
        return INFO_TILE_EFFECT_DUT;
    }
}
