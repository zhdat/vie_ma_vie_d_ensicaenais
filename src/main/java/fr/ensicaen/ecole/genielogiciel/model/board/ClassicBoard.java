package fr.ensicaen.ecole.genielogiciel.model.board;

import fr.ensicaen.ecole.genielogiciel.model.tile.*;

public class ClassicBoard extends Board{
    public ClassicBoard() {
        _numberOfTiles = 64;

        Tile[] tiles;
        tiles = new Tile[_numberOfTiles];
        tiles[0] = new StartOfTheYear(0);
        tiles[1] = new English(1);
        tiles[2] = new Sensor(2);
        tiles[3] = new English(3);
        tiles[4] = new IWE(4);
        tiles[5] = new Cplusplus(5);
        tiles[6] = new LVTwo(6);
        tiles[7] = new Revision(7);
        tiles[8] = new Thermodynamics(8);
        tiles[9] = new ChemistryManipulation(9);
        tiles[10] = new Party(10);
        tiles[11] = new SDSR(11);
        tiles[12] = new Maths(12);
        tiles[13] = new English(13);
        tiles[14] = new LVTwo(14);
        tiles[15] = new FinancialManagement(15);
        tiles[16] = new SmartCard(16);
        tiles[17] = new BurnOut(17);
        tiles[18] = new FinancialManagement(18);
        tiles[19] = new Cryptography(19);
        tiles[20] = new SDSR(20);
        tiles[21] = new Exams(21);
        tiles[22] = new StartOfTheYear(22);
        tiles[23] = new Party(23);
        tiles[24] = new English(24);
        tiles[25] = new SmartCard(25);
        tiles[26] = new IWE(26);
        tiles[27] = new Hollidays(27);
        tiles[28] = new Party(28);
        tiles[29] = new DataBase(29);
        tiles[30] = new Revision(30);
        tiles[31] = new LVTwo(31);
        tiles[32] = new ChemistryManipulation(32);
        tiles[33] = new SylvieMaloMeeting(33);
        tiles[34] = new Maths(34);
        tiles[35] = new Hollidays(35);
        tiles[36] = new SDSR(36);
        tiles[37] = new Party(37);
        tiles[38] = new Waves(38);
        tiles[39] = new RecruitmentCourse(39);
        tiles[40] = new OrganicChemistry(40);
        tiles[41] = new Cplusplus(41);
        tiles[42] = new Exams(42);
        tiles[43] = new StartOfTheYear(43);
        tiles[44] = new RecruitmentCourse(44);
        tiles[45] = new Maths(45);
        tiles[46] = new SDSR(46);
        tiles[47] = new SmartCard(47);
        tiles[48] = new Sensor(48);
        tiles[49] = new Party(49);
        tiles[50] = new OrganicChemistry(50);
        tiles[51] = new Revision(51);
        tiles[52] = new Thermodynamics(52);
        tiles[53] = new ChemistryManipulation(53);
        tiles[54] = new Cplusplus(54);
        tiles[55] = new SylvieMaloMeeting(55);
        tiles[56] = new DataBase(56);
        tiles[57] = new Cryptography(57);
        tiles[58] = new IWE(58);
        tiles[59] = new Party(59);
        tiles[60] = new LVTwo(60);
        tiles[61] = new Waves(61);
        tiles[62] = new English(62);
        tiles[63] = new SDSR(63);
        _tiles = tiles;
    }
}
