package fr.ensicaen.ecole.genielogiciel.model;

public class Joueur {
    private String _nom;
    private Softskill _softskill;
    private Provenance _provenance;
    private Filiere _filiere;
    private int _competence;
    private int _position;

    public Joueur(String nom, Softskill softskill, Provenance provenance, Filiere filiere){
        _nom = nom;
        _softskill = softskill;
        _provenance = provenance;
        _filiere = filiere;
        _position = 0; /* A voir avec le fichier fxml... */
        _competence = 0;
    }
    public void avancer(int nbCases){
        _position += nbCases;
        /* @TODO : Vérifier si le joueur est arriver à la fin !*/
    }
    public void reculer(int nbCases){
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
    }
    public void randomSoftskill(){
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
    public Filiere getFiliere(){
        return _filiere;
    }
    public void setPosition(int i){
        _position = i;
    }
    public Provenance getProvenance(){
        return _provenance;
    }
    public String getName(){
        return _nom;
    }
    public Softskill getSoftskill(){
        return _softskill;
    }
    /* Getters et Setters à ajouter si besoin */
}
