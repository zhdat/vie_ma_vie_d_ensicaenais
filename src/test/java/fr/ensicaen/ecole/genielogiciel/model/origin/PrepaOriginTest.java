package fr.ensicaen.ecole.genielogiciel.model.origin;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrepaOriginTest {

    private static PrepaOrigin prepa;

    @BeforeAll
    static void beforeAll() {
        prepa = new PrepaOrigin(new Player() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
    }


    private final int PREPA_MATH_EFFECT = +1;
    private final int PREPA_INFO_EFFECT = -1;

    @Test
    void testEffectOnMath() {
        assert (prepa.getEffectOnMathsTile() == PREPA_MATH_EFFECT);
    }

    @Test
    void testEffectOnInfo() {
        assert(prepa.getEffectOnInfoTile() == PREPA_INFO_EFFECT);
    }
}
