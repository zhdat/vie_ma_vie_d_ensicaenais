package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;

public class ChemistryManipulation extends Tile {
    public ChemistryManipulation(int position) {
    super(position);
}

    @Override
    public void appliquerEffet(Player player) {
        if (player.getFiliere() == Sector.MATERIAUX){
            if (player.getProvenance() == Origin.AST){
                player.setCompetence(1);
            } else if (player.getProvenance() == Origin.PREPA) {
                player.setCompetence(-1);
            }
        }
    }

}
