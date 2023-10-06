package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Examens extends Tile {
    public Examens(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        if (player.getPosition() >= 21 && player.getCompetence() < 4){
            player.setPosition(0);
        }
        if (player.getPosition() >= 42 && player.getCompetence() < 8){
            player.setPosition(22);
        }
        if (player.getPosition() == 64 && player.getCompetence() < 12){
            player.setPosition(43);
        }
    }
}
