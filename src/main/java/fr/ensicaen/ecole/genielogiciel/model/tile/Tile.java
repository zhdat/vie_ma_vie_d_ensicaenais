package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public interface Tile {
    public int getPlayerLevel();

    public Origin getPlayerOrigin();

    public Softskills getPlayerSoftskills();

    public Player getPlayerType();
}