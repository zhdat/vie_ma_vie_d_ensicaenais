package fr.ensicaen.ecole.genielogiciel.model.tile;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import fr.ensicaen.ecole.genielogiciel.model.player.Sector;

public class Waves extends Tile{

        public Waves(int position) { super(position);}

        @Override
        public void appliquerEffet(Player player) {
            if (player.getFiliere() == Sector.ELECTRONIQUE){
                player.setCompetence(1);
            }
        }
}

