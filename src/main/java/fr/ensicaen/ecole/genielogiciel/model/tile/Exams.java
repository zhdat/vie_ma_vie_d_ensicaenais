package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Exams extends Tile {
    public Exams(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        if (player.getPosition() >= 21 && player.getPosition() < 42){
            if (player.getSkillLevel() < 4){
                player.setPosition(0);
            } else {
                player.setPosition(22);
                player.setSkillLevel(player.getSkillLevel() - 4);
            }
        } else if (player.getPosition() >= 42){
            if (player.getSkillLevel() < 4){
                player.setPosition(22);
            } else {
                player.setPosition(43);
                player.setSkillLevel(player.getSkillLevel() - 4);
            }
        }
    }
}
