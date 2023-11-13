package Fases;

public class Fase3 {
    private static String[][] matriz3 ={{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 0
                                {"aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaDireita.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 1
                                {"aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaDireita.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 2
                                {"aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaDireita.png", null, null, null, null, null, null, null, "arbusto2.png"}, // LINHA 3
                                {"aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaCentro.png", "aguaDireita.png", null, null, null, null, null, "arbusto2.png", null, "arbusto2.png", }, // LINHA 4
                                {"aguaBaixo.png", "aguaBaixo.png", "aguaBaixo.png", "aguaBaixo.png", "aguaBaixo.png", "aguaBaixo.png", "aguaBaixo.png", "aguaCanto.png", null, null, null, null, null, null, null, "arbusto2.png" }, // LINHA 5
                                {"arbustoSepSup.png", "arbustoSepSup.png", "arbustoSepSup.png", null, null, null, null, null, null, "arbusto2.png", "arbusto2.png", "arbusto2.png", null, null, null, null }, // LINHA 6
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, null, null, null, "arbusto2.png", "arbusto2.png", null, "arbusto2.png", }, // LINHA 7
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, "arbusto2.png", null, null, null, null, null, "arbusto2.png", }, // LINHA 8
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png", }, // LINHA 9
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", null, "arbusto2.png", "arbusto2.png", }, // LINHA 10
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", null, "arbusto2.png", "arbusto2.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
    
    private static int[] inimigos3 = {2, 1, 0, 8, 3, 1, 1, 6, 4};

    private static char[] teleports3 = {2, 'd', 'c', 2, 13, 11, 13, 'e', 'f', 6, 1, 6, 15};

    public static String[][] getMatrizStrings() {
        return matriz3;
    }
    
    public static int[] getArrayInimigos() {
        return inimigos3;
    }
    
    public static char[] getArrayTeleports() {
        return teleports3;
    }
}