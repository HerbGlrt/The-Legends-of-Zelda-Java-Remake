package Fases;

public class FaseBonus {
   static String[][] matrizBonus ={{"coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", }, // LINHA 0
                                {"arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png",}, // LINHA 1
                                {"arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png","arbvermelho.png",}, // LINHA 2
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", null, null, null, null, null, null, null, null, null, null, null, null, "arbvermelho.png", "arbvermelho.png", }, // LINHA 3
                                {"arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", null, null, "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", }, // LINHA 10
                                {"arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", null, null, "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", "arbvermelho.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
   
   static char[] teleportsBonus = {1, 'i', 'j', 4, 3, 7, 11};

    public static String[][] getMatrizStrings() {
        return matrizBonus;
    }
    
    static char[] getArrayTeleports() {
        return teleportsBonus;
    }
}