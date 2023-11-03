package Fases;

public class Fase {
    private static String[][] matrizStrings;
    private static int[] arrayInimigos; // Estrutura do array: {qtd de inimigos na fase; tipo inimigo 1; coordenada x inimigo 1; coordenada y inimigo 1; tipo inimigo 2; ...}
    //Se tipo inimigo = 0, Oktorok; = 1, ZigueZague; = 2, VaiVem
    private static char[] arrayTeleports;  // Estrutura do array: {qtd de TP's na fase; identificador TP1; identificador do destino TP1; coordenada x hero ao teleportar; coordenada y hero ao teleportar; coordenada x TP1; coordenada y TP1, identificador TP2; ...} 

    public Fase() {
    }
  
    public static char[] getArrayTeleports() {
        return arrayTeleports;
    }

    public static void setArrayTeleports(char[] arrayTeleports) {
        Fase.arrayTeleports = arrayTeleports;
    }
    
    public static char getElemArrayTeleport(int i) {
        return Fase.arrayTeleports[i];
    }

    public static int[] getArrayInimigos() {
        return arrayInimigos;
    }

    public static void setArrayInimigos(int[] arrayInimigos) {
        Fase.arrayInimigos = arrayInimigos;
    }
    
    public static int getElemArrayInimigos(int i) {
        return Fase.arrayInimigos[i];
    }
    
    public static String getElemMatrizStrings(int i, int j) {
        return Fase.matrizStrings[i][j];
    }

    public static void setMatrizStrings(String[][] matrizStrings) {
        Fase.matrizStrings = matrizStrings;
    }
}