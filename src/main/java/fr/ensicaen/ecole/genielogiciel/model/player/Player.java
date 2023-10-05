package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.sofskills.Softskill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Player {
    private final String _nom;
    private Softskill _softskill;
    private final Origin _origin;
    private final Sector _sector;
    private int _competence;
    private int _position;
    private boolean _finsh;

    private Color _color;

    public Player(String nom, Softskill softskill, Origin origin, Sector sector, Color color){
        _nom = nom;
        _softskill = softskill;
        _origin = origin;
        _sector = sector;
        _position = 0; /* A voir avec le fichier fxml... */
        _competence = 0;
        _color = color;
        _finsh = false;
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
        if (_softskill == Softskill.ASSIDU){
            return 1;
        } else if (_softskill == Softskill.BRILLANT){
            return 2;
        } else if (_softskill == Softskill.DILETTANTE) {
            return 0.5;
        }
        return 1;
    }
    public void randomSoftskill(){
        int rand = (int)(Math.random() * 3);
        if (rand == 0){
            _softskill = Softskill.ASSIDU;
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
    public Color getColor() {
        return _color;
    }
    public void setFinsh(){
        _finsh = true;
    }
    public boolean getFinish(){
        return _finsh;
    }

    /* Getters et Setters à ajouter si besoin */
}
