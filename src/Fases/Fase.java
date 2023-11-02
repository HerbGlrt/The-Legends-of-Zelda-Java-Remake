package Fases;
import Modelo.Estatico;
import Modelo.Personagem;
import java.util.ArrayList;

public class Fase {
    Estatico[][] parede = new Estatico[16][16];
    private String[][] matrizStrings;
    private String[] matrizInimigos;

    public Fase() {
    }
    
    public Personagem criaFase(String[][] matriz, int i, int j){
        this.setMatrizStrings(matriz);
                if(getMatrizStrings(i,j) != null){
                parede[i][j] = new Estatico(getMatrizStrings(i,j));
                if(j == 1 || j == 3 || j == 5){parede[i][j].setIsCoracao(1);}   // Se for um sprite de coração, seta isCoracao
                parede[i][j].setPosicao(i,j);
            }
        return parede[i][j];
    }

    public void apagaTudo(ArrayList<Personagem> faseAtual) {
       this.matrizStrings = null;   // Define a matriz de strings da fase como sendo nula
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                parede[i][j] = null;    // Percorre toda a matriz de objetos da fase, definindo objeto a objeto como nulo
            }
        }
        for(int i = 1; i <= faseAtual.size(); i++){
            faseAtual.remove(i);    // Apaga todos os elementos no vetor de personagens da fase, menos o hero
        }
    }

    public String[] getMatrizInimigos() {
        return matrizInimigos;
    }

    public void setMatrizInimigos(String[] matrizInimigos) {
        this.matrizInimigos = matrizInimigos;
    }
    
    public String getMatrizStrings(int i, int j) {
        return this.matrizStrings[i][j];
    }

    public void setMatrizStrings(String[][] matrizStrings) {
        this.matrizStrings = matrizStrings;
    }
}