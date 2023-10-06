package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.FormerStudies;
import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Maths extends Tile {
    public Maths(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        if (player.getFormerStudies() == FormerStudies.PREPA){
            player.setSkillLevel(1);
        } else {
            player.setSkillLevel(-1);
        }
    }
}
