package fr.ensicaen.ecole.genielogiciel.model.origin;

import fr.ensicaen.ecole.genielogiciel.model.player.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DUTOriginTest {
    private static DUTOrigin dut;
    private final int DUT_MATH_EFFECT = -1;
    private final int DUT_INFO_EFFECT = +1;

    @BeforeAll
    static void beforeAll() {
        dut = new DUTOrigin(new Player() {
        });
    }

    @Test
    void testEffectOnMath() {
        assert(dut.getEffectOnMathsTile() == DUT_MATH_EFFECT);
    }

    @Test
    void testEffectOnInfo() {
        assert(dut.getEffectOnInfoTile() == DUT_INFO_EFFECT);
    }
}
