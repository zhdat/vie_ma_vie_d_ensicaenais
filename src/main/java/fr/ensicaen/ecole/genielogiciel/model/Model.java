package fr.ensicaen.ecole.genielogiciel.model;

import fr.ensicaen.ecole.genielogiciel.model.origin.Provenance;
import fr.ensicaen.ecole.genielogiciel.model.player.Filiere;
import fr.ensicaen.ecole.genielogiciel.model.player.Joueur;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;
import fr.ensicaen.ecole.genielogiciel.model.tile.*;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

public class Model {
    private String _nickname;
    private Joueur[] _players;
    private Plateau _board;
    private Case[] _cases;
    private int _turn;
    private int _nbCases = 12;

    public Model() {
        _cases = new Case[_nbCases];
        _cases[0] = new Rentrée(0);
        _cases[1] = new Anglais(1);
        _cases[2] = new Anglais(2);
        _cases[3] = new WEI(3);
        _cases[4] = new Cpp(4);
        _cases[5] = new LV2(5);
        _cases[6] = new Révision(6);
        _cases[7] = new Crypto(7);
        _cases[8] = new Soirées(8);
        _cases[9] = new Recruitment(9);
        _cases[10] = new BaseDeDonnée(10);
        _cases[11] = new Burnout(11);

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

    public int playTurn(int playerIndex, int dice) {
        System.out.println(_players[playerIndex].getName());
        if (_players[playerIndex].getSoftskill() == Softskill.ASSIDUS){
            _players[playerIndex].avancer(dice);
        } else if (_players[playerIndex].getSoftskill() == Softskill.BRILLANT) {
            _players[playerIndex].avancer(dice * 2);
        } else if (_players[playerIndex].getSoftskill() == Softskill.DILETTANTE) {
            _players[playerIndex].avancer(dice / 2);
        }
        System.out.println(_players[playerIndex].getName() + "-->" + _players[playerIndex].getPosition());
        if (_players[playerIndex].getPosition() >= _nbCases){
            System.out.println(_players[playerIndex].getName() + " Win !!!");
        }
        /*_cases[_players[playerIndex].getPosition()].appliquerEffet(_players[playerIndex]);*/ // @TODO : Résoudre pbm --> error: incompatible types: fr.ensicaen.ecole.genielogiciel.model.player.Joueur cannot be converted to fr.ensicaen.ecole.genielogiciel.model.Joueur
        return _players[playerIndex].getPosition();
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
