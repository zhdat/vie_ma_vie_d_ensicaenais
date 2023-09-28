package fr.ensicaen.ecole.genielogiciel.model.player;

import fr.ensicaen.ecole.genielogiciel.model.origin.BachelorOrigin;
import fr.ensicaen.ecole.genielogiciel.model.origin.DUTOrigin;
import fr.ensicaen.ecole.genielogiciel.model.origin.Origin;
import fr.ensicaen.ecole.genielogiciel.model.origin.PrepaOrigin;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Assidu;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Brillant;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Dilétante;
import fr.ensicaen.ecole.genielogiciel.model.softskills.Softskills;

public class playerFactory {
    public static Player createPlayer(String name, String major, String origin, String softSkill) throws Exception {
        Softskills s;
        switch (softSkill) {
            case "Assidu" : s = new Assidu(); break;
            case "Brillant" : s = new Brillant(); break;
            case "Diletante" : s = new Dilétante(); break;
            default : throw new Exception();
        }
        Origin o;
        switch (origin) {
            case "BachelorOrigin" : o = new BachelorOrigin(); break;
            case "DUTOrigin" : o = new DUTOrigin(); break;
            case "PrepaOrigin" : o = new PrepaOrigin(); break;
            default : throw new Exception();
        }

        switch (major) {
            case "Elec" : return new Elec(name, s, o);
            case "Info" : return new Info(name, s, o);
            case "Mc" : return new Mc(name, s, o);
            default : throw new Exception();
        }
    }
}
