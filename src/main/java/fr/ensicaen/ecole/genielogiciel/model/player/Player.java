package fr.ensicaen.ecole.genielogiciel.model.player;

import javafx.scene.paint.Color;

public class Player {
    private final String _name;
    private SoftSkill _softSkill;
    private FormerStudies _formerStudies;
    private Major _major;
    private int _skillLevel;
    private int _position;
    private boolean _finish;

    private final Color _color;

    public Player(String name, SoftSkill softSkill, FormerStudies formerStudies, Major major, Color color){
        _name = name;
        _softSkill = softSkill;
        _formerStudies = formerStudies;
        _major = major;
        _position = 0;
        _skillLevel = 0;
        _color = color;
        _finish = false;
    }
    public void goForward(int numberOfTiles){
        _position += numberOfTiles;
    }
    public void goBackward(int numberOfTiles){
        _position -= numberOfTiles;
    }
    public double softSkillEffect(){
        switch (_softSkill){
            case HARDWORKING :
                return 1;
            case BRILLIANT:
                return 2;
            case DILETTANTE:
                return 0.5;
            default :
                return 1;
        }
    }
    public void setRandomSoftSkill() {
        int rand = (int) (Math.random() * 3);
        switch (rand) {
            case 0:
                _softSkill = SoftSkill.DILETTANTE;
                break;
            case 1:
                _softSkill = SoftSkill.HARDWORKING;
                break;
            case 2:
                _softSkill = SoftSkill.BRILLIANT;
                break;
        }
    }

    public void increaseSkillLevel(int i){
        _skillLevel += i;
    }
    public Major getMajor(){
        return _major;
    }
    public void setPosition(int i){
        _position = i;
    }
    public FormerStudies getFormerStudies(){
        return _formerStudies;
    }
    public String getName(){
        return _name;
    }
    public SoftSkill getSoftSkill(){
        return _softSkill;
    }
    public int getSkillLevel(){
        return _skillLevel;
    }
    public int getPosition(){
        return _position;
    }
    public Color getColor() {
        return _color;
    }
    public void setFinish(){
        _finish = true;
    }
    public boolean getFinish(){
        return _finish;
    }
    public void setSoftSkill(SoftSkill softSkill) {
        _softSkill = softSkill;
    }

    public void setFormerStudies(FormerStudies formerStudies) {
        _formerStudies = formerStudies;
    }
    public void setMajor(Major major) {
        _major = major;
    }
    public void setSkillLevel(int skillLevel){
        _skillLevel = skillLevel;
    }
}
