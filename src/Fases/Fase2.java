package Fases;

public class Fase2{
    private static String[][] matriz2 ={{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 0
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 1
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 2
                                {"arbusto2.png", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png"}, // LINHA 3
                                {"arbusto2.png", null, null, null, null, null, null, "arbusto2.png", null, "arbusto2.png", null, null, null, "arbusto2.png", null, "arbusto2.png", }, // LINHA 4
                                {"arbusto2.png", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png" }, // LINHA 5
                                {null, null, null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png" }, // LINHA 6
                                {"arbusto2.png", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png", }, // LINHA 7
                                {"arbusto2.png", null, null, null, null, null, null, "arbusto2.png", null, "arbusto2.png", null, null, null, "arbusto2.png", null, "arbusto2.png", }, // LINHA 8
                                {"arbusto2.png", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png", }, // LINHA 9
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", null, "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 10
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", null, "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };
    
    public static int[] inimigos2 = {3, 1, 0, 8, 3, 1, 1, 6, 4, 1, 2, 4, 11};
    
    private static char[] teleports2 = {2, 'f', 'e' , 6, 14, 6, 0, 'g', 'h', 2, 7, 11, 7};

    public static String[][] getMatrizStrings() {
        return matriz2;
    }

    public static int[] getArrayInimigos() {
        return inimigos2;
    }
    
    public static void setArrayInimigos(int[] inimigos) {
        Fase2.inimigos2 = inimigos;
    }
    
    public static char[] getArrayTeleports() {
        return teleports2;
    }
}