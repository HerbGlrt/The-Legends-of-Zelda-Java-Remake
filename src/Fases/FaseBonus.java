package Fases;

public class FaseBonus {
   private static String[][] matrizBonus ={{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 0
                                {"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",},  // LINHA 1
                                {"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",}, // LINHA 2
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 3
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 4
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 5
                                {"pedra.png", "pedra.png", null, null, null, "fogo.png", null, "velho.png",  null, "fogo.png", null, null, null,null, "pedra.png","pedra.png", }, // LINHA 6
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 7
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 8
                                {"pedra.png", "pedra.png", null, null, null, null, null, null, null, null, null, null, null, null, "pedra.png","pedra.png", }, // LINHA 9
                                {"pedra.png","pedra.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png",null,"pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedraSup.png","pedra.png","pedra.png",}, // LINHA 10
                                {"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",null,"pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png","pedra.png",}, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
   
    private static char[] teleportsBonus = {1, 'j', 'i', 3, 4, 11, 7};

    public static String[][] getMatrizStrings() {
        return matrizBonus;
    }
    
    public static char[] getArrayTeleports() {
        return teleportsBonus;
    }
}