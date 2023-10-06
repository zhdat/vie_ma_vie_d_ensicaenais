package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Major;

public class OrganicChemistry extends Tile{
    public OrganicChemistry(int position) { super(position);}

    @Override
    public void applyTileEffect(Player player) {
        if (player.getMajor() == Major.MATERIALS){
            player.increaseSkillLevel(1);
        }
    }
}
