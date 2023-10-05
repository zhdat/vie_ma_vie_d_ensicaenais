package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;

public class Player {
    private final String _nom; // FIXME mélange français anglais.
    private Softskill _softskill;
    private final Origin _origin;
    private final Sector _sector;
    private int _competence; // FIXME peut être un meilleur nom skillLevel
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
        // FIXME ne pas laisser de TODO en production (ici fin d'itération)
        /* @TODO : Vérifier si le joueur est arriver à la fin !*/
    }
    public void goBackward(int nbCases){
        _position -= nbCases;
        /* @TODO : Vérifier si le joueur est arriver au début !*/
    }
    public double softskill(){ // FIXME mauvaise casse -> camel Case
        // FIXME : le nom de la focntion n'est pas en adéquation avec le contenu -> changer le nom
        if (_softskill == Softskill.ASSIDU){
            return 1;
        } else if (_softskill == Softskill.BRILLANT){
            return 2;
        } else if (_softskill == Softskill.DILETTANTE) {
            return 0.5;
        } // Est-ce possible ?
        return 1;
    }
    public void randomSoftskill(){ // FIXME rendre le nom de la méthode plus explicite
        int rand = (int)(Math.random() * 3);
        if (rand == 0){
            _softskill = Softskill.ASSIDU;
        } else if (rand == 1){
            _softskill = Softskill.BRILLANT;
        } else if (rand == 2){
            _softskill = Softskill.DILETTANTE;
        }
        // FIXME y a t-il d'autres cas ? préférer un switch
    }
    // FIXME tous ces accesseurs me semblent suspects d'une mauvaise répartition des responsabilites
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
