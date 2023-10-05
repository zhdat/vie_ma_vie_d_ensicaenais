package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;

public class Player {
    private String _nom;
    private Softskill _softskill;
    private Origin _origin;
    private Sector _sector;
    private int _competence;
    private int _position;

    public Player(String nom, Softskill softskill, Origin origin, Sector sector){
        _nom = nom;
        _softskill = softskill;
        _origin = origin;
        _sector = sector;
        _position = 0; /* A voir avec le fichier fxml... */
        _competence = 0;
    }
    public void goForward(int nbCases){
        _position += nbCases;
        /* @TODO : Vérifier si le joueur est arriver à la fin !*/
    }
    public void goBackward(int nbCases){
        _position -= nbCases;
        /* @TODO : Vérifier si le joueur est arriver au début !*/
    }
    public double softskill(){
        if (_softskill == Softskill.ASSIDUS){
            return 1;
        } else if (_softskill == Softskill.BRILLANT){
            return 2;
        } else if (_softskill == Softskill.DILETTANTE) {
            return 0.5;
        }
        return 1;
    }    public void randomSoftskill(){
        int rand = (int)(Math.random() * 3);
        if (rand == 0){
            _softskill = Softskill.ASSIDUS;
        } else if (rand == 1){
            _softskill = Softskill.BRILLANT;
        } else if (rand == 2){
            _softskill = Softskill.DILETTANTE;
        }
    }

    public void setCompetence(int i){
        _competence += i;
    }
    public Sector getFiliere(){
        return _sector;
    }
    public void setPosition(int i){
        _position = i;
    }
    public Origin getProvenance(){
        return _origin;
    }
    public String getName(){
        return _nom;
    }
    public Softskill getSoftskill(){
        return _softskill;
    }
    public int getPosition(){
        return _position;
    }
    /* Getters et Setters à ajouter si besoin */
}
