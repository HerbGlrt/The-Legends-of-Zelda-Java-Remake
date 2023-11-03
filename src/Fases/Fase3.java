package Fases;

public class Fase3 {
    static String[][] matriz3 ={{"coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", }, // LINHA 0
                                {"aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguaborda2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 1
                                {"aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguaborda2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 2
                                {"aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguaborda2.png", null, null, null, null, null, null, null, "arbusto2.png"}, // LINHA 3
                                {"aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguaborda2.png", null, null, null, null, null, "arbusto2.png", null, "arbusto2.png", }, // LINHA 4
                                {"aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguacentro.png", "aguaborda1.png", null, null, null, null, null, null, null, null }, // LINHA 5
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, "arbusto2.png", "arbusto2.png", "arbusto2.png", null, null, null, "arbusto2.png" }, // LINHA 6
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, null, null, null, "arbusto2.png", "arbusto2.png", null, "arbusto2.png", }, // LINHA 7
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, "arbusto2.png", null, null, null, null, null, "arbusto2.png", }, // LINHA 8
                                {"arbusto.png", "arbusto.png", "arbusto.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png", }, // LINHA 9
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", null, "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 10
                                {"arbusto.png", "arbusto.png", "arbusto.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", null, "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
    
    static char[] teleports3 = {2, 'd', 'c', 13, 2, 13, 11, 'e', 'f', 1, 6, 15, 6};

    static String[][] getMatrizStrings() {
        return matriz3;
    }
    
    static char[] getArrayTeleports() {
        return teleports3;
    }
}