package fr.ensicaen.ecole.genielogiciel.model.origin;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public abstract class Origin implements Player {

    public abstract int getEffectOnMathsTile();

    public abstract int getEffectOnInfoTile();
}
