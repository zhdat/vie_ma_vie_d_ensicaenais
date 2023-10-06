package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;

public class ChemistryManipulation extends Tile {
    public ChemistryManipulation(int position) {
    super(position);
}

    @Override
    public void applyTileEffect(Player player) {
        if (player.getMajor() == Major.MATERIALS){
            if (player.getFormerStudies() == FormerStudies.AST){
                player.setSkillLevel(1);
            } else if (player.getFormerStudies() == FormerStudies.PREPA) {
                player.setSkillLevel(-1);
            }
        }
    }

}
