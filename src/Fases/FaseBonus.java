package Fases;

public class FaseBonus {
   private static String[][] matrizBonus ={{"coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", }, // LINHA 0
                                {"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",},
                                {"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",},
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png","pedra.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png",null,"pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedra.png","pedra.png",},
                                {"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",null,"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",},
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
   
    private static char[] teleportsBonus = {1, 'i', 'j', 3, 4, 11, 7};

    public static String[][] getMatrizStrings() {
        return matrizBonus;
    }
    
    public static char[] getArrayTeleports() {
        return teleportsBonus;
    }
}