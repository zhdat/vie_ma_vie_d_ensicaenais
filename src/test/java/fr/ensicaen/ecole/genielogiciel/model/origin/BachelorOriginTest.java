package fr.ensicaen.ecole.genielogiciel.model.origin;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BachelorOriginTest {

    private static BachelorOrigin bachelor;
    private final int BACHELOR_MATH_EFFECT = -1;
    private final int BACHELOR_INFO_EFFECT = +1;

    @BeforeAll
    static void beforeAll() {
        bachelor = new BachelorOrigin();
    }

    @Test
    void testEffectOnMath() {
        assert(bachelor.getEffectOnMathsTile() == BACHELOR_MATH_EFFECT);
    }

    @Test
    void testEffectInfo() {
        assert(bachelor.getEffectOnInfoTile() == BACHELOR_INFO_EFFECT);
    }
}
