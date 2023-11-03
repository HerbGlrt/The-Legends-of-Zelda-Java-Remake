package Fases;

public class Fase {
    private static String[][] matrizStrings;
    private static String[] matrizInimigos;
    private static char[] arrayTeleports;  // Estrutura do array: {qtd de TP's na fase; identificador TP1; identificador do destino TP1; coordenada x hero ao teleportar; coordenada y hero ao teleportar; coordenada x TP1; coordenada y TP1, identificador TP2; ...} 

    public Fase() {
    }
  
    public static char[] getArrayTeleports() {
        return arrayTeleports;
    }

    public static void setArrayTeleports(char[] matrizTeleports) {
        Fase.arrayTeleports = matrizTeleports;
    }
    
    public static char getElemArrayTeleport(int i) {
        return Fase.arrayTeleports[i];
    }
    
    public static String[] getMatrizInimigos() {
        return matrizInimigos;
    }

    public static void setMatrizInimigos(String[] matrizInimigos) {
        Fase.matrizInimigos = matrizInimigos;
    }
    
    public static String getElemMatrizStrings(int i, int j) {
        return Fase.matrizStrings[i][j];
    }

    public static void setMatrizStrings(String[][] matrizStrings) {
        Fase.matrizStrings = matrizStrings;
    }
}