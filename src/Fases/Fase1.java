package Fases;

public class Fase1{
    private static String[][] matriz1 ={{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 0
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", null, "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 1
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", null, "arbusto.png", "arbustoSepDir.png", null,  "arbustoSepEsq.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 2
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbustoSepDir.png", null, null, null, null, null, null, null, "arbustoSepEsq.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 3
                                {"arbusto.png", "arbusto.png", "arbustoSepDir.png", null, null, null, null, null, null, null, null, null,  "arbustoSepEsq.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 4
                                {"arbusto.png", "arbustoSepDir.png", null, null, null, null, null, null, null, null, null, null, null, "arbustoSepEsq.png", "arbusto.png", "arbusto.png", }, // LINHA 5
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto.png", "arbusto.png", }, // LINHA 6
                                {"arbustoSepSup.png", "arbustoSepSupDir.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbusto.png", "arbusto.png", }, // LINHA 7
                                {"arbusto.png", "arbusto.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbusto.png", "arbusto.png", }, // LINHA 8
                                {"arbusto.png", "arbusto.png", null, null, null, null, null, null, null, null, null, null, null, "arbustoSepSupEsq.png", "arbusto.png", "arbusto.png", }, // LINHA 9
                                {"arbusto.png", "arbusto.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 10
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
    
    private static char[] teleports1 = {3, 'a', 'b', 6, 14, 6, 0, 'i', 'j', 10, 7, 2, 4, 'h', 'g', 10, 7, 1, 7};
    
    public static String[][] getMatrizStrings() {
        return matriz1;
    }

    public static char[] getArrayTeleports() {
        return teleports1;
    }
}