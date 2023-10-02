package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;

public class Anglais extends Tile {
    public Anglais(int position) {
        super(position);
    }

    @Override
    public void appliquerEffet(Player player) {
        player.setCompetence(1);
    }
}
