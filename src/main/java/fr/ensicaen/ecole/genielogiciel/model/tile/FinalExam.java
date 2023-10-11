package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;


public class FinalExam extends Tile {

    public FinalExam(int position) {
        super(position);
    }

    @Override
    public void applyTileEffect(Player player) {
        if (player.getSkillLevel() < 4){
            player.setPosition(43);
        } else {
            player.setFinish();
            System.out.println(player.getName() + " Win !!!");
        }
    }
}
