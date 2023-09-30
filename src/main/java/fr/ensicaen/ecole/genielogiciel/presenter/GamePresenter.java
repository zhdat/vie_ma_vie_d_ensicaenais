package fr.ensicaen.ecole.genielogiciel.presenter;

import fr.ensicaen.ecole.genielogiciel.model.*;
import fr.ensicaen.ecole.genielogiciel.view.GameView;

import java.lang.invoke.CallSite;

public final class GamePresenter {
    private final Model _model;
    private GameView _view;
    private boolean _end = false;
    private int result;
    private int nbTour = 0;

    public GamePresenter( String nickName ) {
        _model = new Model();
        _model.setNickname(nickName);
    }

    public void setView( GameView view ) {
        _view = view;
    }

    public void runGameLoop() { /* Le système de dé est à coder ici*/
        nbTour ++;
        System.out.println("Et c'est parti...");
        De de = new De();
        if (nbTour == 0){
            Case[] cases = new Case[63];
            Plateau plateau = new Plateau(cases);

            Joueur joueur1 = new Joueur("Calliste", null, Provenance.AST, Filiere.INFORMATIQUE);
            Joueur joueur2 = new Joueur("Maxime", null, Provenance.PREPA, Filiere.INFORMATIQUE);
            Joueur joueur3 = new Joueur("Clement", null, Provenance.PREPA, Filiere.INFORMATIQUE);
            Joueur joueur4 = new Joueur("Blaise", null, Provenance.PREPA, Filiere.INFORMATIQUE);

            joueur1.randomSoftskill();
            joueur2.randomSoftskill();
            joueur3.randomSoftskill();
            joueur4.randomSoftskill();

        }

        result = de.lancerDe();
        _view.update();

    }

    private void update() {
        // Update the model
    }

    private void render() {
        // Display the result on the view
        //_view.toto();
    }
    public int getResult(){
        return result;
    }
}