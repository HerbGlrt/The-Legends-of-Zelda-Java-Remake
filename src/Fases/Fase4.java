package Fases;

public class Fase4 {
    private static String[][] matriz4 ={{"coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", }, // LINHA 0
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", null, null, "arbusto.png", "arbusto.png", }, // LINHA 1
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", null, null, "arbusto.png", "arbusto.png", }, // LINHA 2
                                {"arbusto.png", null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto.png", "arbusto.png", }, // LINHA 3
                                {"arbusto.png", null, null, null, null, null, null, null, "arbustoisolado.png", null, null, null, null, null, "arbustoSepEsq.png", "arbusto.png", }, // LINHA 4
                                {"arbusto.png", null, null, null, null, null, null, null, null, null, "arbustoisolado.png", null, null, null, null, "arbustoSepEsq.png", }, // LINHA 5
                                {"arbusto.png", null, "arbustoisolado.png", null, null, "arbustoisolado.png", null, null, "arbustoisolado.png", null, null, null, null, null, null, null, }, // LINHA 6
                                {"arbusto.png", null, null, null, null, null, null, null, null, null, "arbustoisolado.png", null, null, null, null, "arbustoSepSupEsq.png", }, // LINHA 7
                                {"arbusto.png", null, null, null, null, null, null, null, "arbustoisolado.png", null, null, null, null, null, "arbustoSepSupEsq.png", "arbusto.png" }, // LINHA 8
                                {"arbusto.png", null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto.png", "arbusto.png"}, // LINHA 9
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 10
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", "arbusto.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
    
    private static char[] teleports4 = {2, 'c', 'd', 13, 10, 13, 1, 'b', 'a', 1, 6, 15, 6};

    public static String[][] getMatrizStrings() {
        return matriz4;
    }
   
    public static char[] getArrayTeleports() {
        return teleports4;
    }
}