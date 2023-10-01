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
    }

    public void startGame() {
        for (Joueur joueur : _players) {
            joueur.randomSoftskill();
        }
        _turn = 1;
    }
    public void playTurn(int playerIndex){
        De de = new De();
        int result = de.lancerDe();
        _players[playerIndex].avancer(result);
        _cases[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);
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
