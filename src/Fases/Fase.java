package Fases;
import Modelo.Estatico;
import Modelo.Personagem;

public class Fase {
    Estatico[][] parede = new Estatico[16][16];
    private String[][] matrizStrings;

    public Fase() {
    }
    
    public Personagem criaFase(String[][] matriz, int i, int j){
        this.setMatrizStrings(matriz);
                if(getMatrizStrings(i,j) != null){
                parede[i][j] = new Estatico(getMatrizStrings(i,j));
                parede[i][j].setPosicao(i,j);
            }
        return parede[i][j];
    }

    public void apagaTudo() {
       this.matrizStrings = null;
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                parede[i][j] = null;
            }
        }
    }
    
    public String getMatrizStrings(int i, int j) {
        return this.matrizStrings[i][j];
    }

    public void setMatrizStrings(String[][] matrizStrings) {
        this.matrizStrings = matrizStrings;
    }
}
