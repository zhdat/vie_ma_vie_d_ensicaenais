package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Provenance;
import fr.ensicaen.ecole.genielogiciel.model.player.Filiere;
import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;
import fr.ensicaen.ecole.genielogiciel.model.tile.BaseDeDonnée;
import fr.ensicaen.ecole.genielogiciel.model.tile.Case;
import fr.ensicaen.ecole.genielogiciel.model.tile.Plateau;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public class Model {
    private String _nickname;
    private Joueur[] _players;
    private Plateau _board;
    private Case[] _cases;
    private int _turn;

    public Model() {
        _cases = new Case[63];
        _board = new Plateau(_cases);
        _players = new Joueur[4];
        Joueur joueur1 = new Joueur("Calliste", null, Provenance.AST, Filiere.INFORMATIQUE);
        Joueur joueur2 = new Joueur("Clément", null, Provenance.PREPA, Filiere.INFORMATIQUE);
        Joueur joueur3 = new Joueur("Maxime", null, Provenance.PREPA, Filiere.INFORMATIQUE);
        Joueur joueur4 = new Joueur("Blaise", null, Provenance.PREPA, Filiere.INFORMATIQUE);
        _players[0] = joueur1;
        _players[1] = joueur2;
        _players[2] = joueur3;
        _players[3] = joueur4;
        int i = 1;
        for (Joueur joueur : _players) {
            System.out.println("Joueur " + i);
            System.out.println(joueur.getName());
            System.out.println(joueur.getPosition());
            System.out.println(joueur.getFiliere());
            System.out.println(joueur.getProvenance());
            System.out.println(joueur.getSoftskill());
            i++;
        }
    }

    public void startGame() {
        int i = 1;
        for (Joueur joueur : _players) {
            System.out.println("joueur " + i);
            System.out.println(joueur.getName());
            joueur.randomSoftskill();
            System.out.println(joueur.getSoftskill());
            i++;
        }

        _turn = 1;
    }

    public void playTurn(int playerIndex) {
        De de = new De();
        int result = de.lancerDe();
        System.out.println(_players[playerIndex].getName());
        _players[playerIndex].avancer(result);
        System.out.println(_players[playerIndex].getPosition());
        /*_cases[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/ // Aucune case de créer encore donc renvoie null
    }

    public String getNickname() {
        return _nickname;
    }

    public void setNickname(String nickname) {
        _nickname = nickname;
    }

    public Joueur[] getPlayers() {
        return _players;
    }

    public Plateau getBoard() {
        return _board;
    }

    public Case[] getCases() {
        return _cases;
    }

    public int getTurn() {
        return _turn;
    }
}
