package Fases;
import Modelo.Estatico;

public class Fase {
    private String[][] matrizStrings;
    private Estatico[][] matrizObjetos;
    private Estatico[][] temp;

    public Fase() {
    }
    
    public void criaFase(String[][] matriz){
        apagaTudo();
        this.setMatrizStrings(matriz);
        for(int j = 1; j < 16; j++){
            for(int i = 0; i < 16; i++){
                setMatrizObjetos(new Estatico(this.getMatrizStrings(i,j)), i, j);
                this.getMatrizObjetos(i, j).setPosicao(i, j);
                }
            }
        }

    public void apagaTudo() {
       this.matrizStrings = null;
       this.matrizObjetos = null;
    }
    
    public String getMatrizStrings(int i, int j) {
        return this.matrizStrings[i][j];
    }

    public void setMatrizStrings(String[][] matrizStrings) {
        this.matrizStrings = matrizStrings;
    }

    public Estatico getMatrizObjetos(int i, int j) {
        return this.matrizObjetos[i][j];
    }

    public void setMatrizObjetos(Estatico st, int i, int j) {
        this.temp[i][j] = st;
    }
}
