package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Cplusplus extends Tile {
    public Cplusplus(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        if (player.getMajor() == Major.COMPUTER_SCIENCE){
            if (player.getFormerStudies() == FormerStudies.AST){
                player.setSkillLevel(1);
            } else if (player.getFormerStudies() == FormerStudies.PREPA) {
                player.setSkillLevel(-1);
            }
        }
    }
}
