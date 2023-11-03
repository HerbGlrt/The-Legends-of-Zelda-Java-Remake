package Fases;
import Modelo.Estatico;
import Modelo.Hero;
import Modelo.Teleport;
import Modelo.Personagem;
import java.util.ArrayList;

public class Fase {
    Estatico[][] parede = new Estatico[16][16];
    private String[][] matrizStrings;
    private String[] matrizInimigos;
    private char[] arrayTeleports;  // Estrutura do array: {qtd de TP's na fase; identificador TP1; identificador do destino TP1; coordenada x hero ao teleportar; coordenada y hero ao teleportar; coordenada x TP1; coordenada y TP1, identificador TP2; ...} 

    public Fase() {
    }
    
    public ArrayList<Personagem> criaFase(int x, Teleport tp, ArrayList<Personagem> faseAtual){
        this.apagaTudo(faseAtual);  // Apaga os elementos da fase atual
        Hero hero = (Hero)faseAtual.get(0); //Pega o heroi do vetor de personagens
        
        if(x == 0){ // Ao iniciar o game o tp passado será nulo, então cria a Fase 1
            this.setMatrizStrings(Fase1.getMatrizStrings());
            this.setArrayTeleports(Fase1.getArrayTeleports());
            hero.setPosicao(6,5);
        } else{
            if(tp.getDestino() == 'a' || tp.getDestino() == 'i' || tp.getDestino() == 'h'){ // Analisa qual a fase a ser criada
            this.setMatrizStrings(Fase1.getMatrizStrings());
            this.setArrayTeleports(Fase1.getArrayTeleports());
        }else if(tp.getDestino() == 'g' || tp.getDestino() == 'f'){
            this.setMatrizStrings(Fase2.getMatrizStrings());
            this.setArrayTeleports(Fase2.getArrayTeleports());
        }else if(tp.getDestino() == 'e' || tp.getDestino() == 'd'){
            this.setMatrizStrings(Fase3.getMatrizStrings());
            this.setArrayTeleports(Fase3.getArrayTeleports());
        }else if(tp.getDestino() == 'c' || tp.getDestino() == 'b'){
            this.setMatrizStrings(Fase4.getMatrizStrings());
            this.setArrayTeleports(Fase4.getArrayTeleports());
        }else if(tp.getDestino() == 'j'){
            this.setMatrizStrings(FaseBonus.getMatrizStrings());
            this.setArrayTeleports(FaseBonus.getArrayTeleports());
        }
        hero.setPosicao(tp.getPosXDest(), tp.getPosYDest());    // Seta a posicao do heroi na nova fase
        }

         for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                    if(getElemMatrizStrings(i, j) != null){
                        parede[i][j] = new Estatico(getElemMatrizStrings(i,j));
                        if(j == 1 || j == 3 || j == 5){parede[i][j].setIsCoracao(1);}   // Se for um sprite de coração, seta isCoracao
                        parede[i][j].setPosicao(i,j);
                        faseAtual.addPeronagem(parede[i][j]);
                    }
                }
            }            
            for(int i = 0; i < (int)getElemArrayTeleport(0); i++){  // Percorre o array de teleport de acordo com a quantidade de TP's por fase
                int pos = i * 6;
                Teleport teleporter = new Teleport(getElemArrayTeleport(pos + 1), getElemArrayTeleport(pos + 2), (int)getElemArrayTeleport(pos + 3), (int)getElemArrayTeleport(pos + 4));
                teleporter.setPosicao(getElemArrayTeleport(pos + 5), getElemArrayTeleport(pos + 6));
                    }
            
            //Adicionar os inimigos;
            return faseAtual;
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

    public char[] getArrayTeleports() {
        return arrayTeleports;
    }

    public void setArrayTeleports(char[] matrizTeleports) {
        this.arrayTeleports = matrizTeleports;
    }
    
    public char getElemArrayTeleport(int i) {
        return this.arrayTeleports[i];
    }
    
    public String[] getMatrizInimigos() {
        return matrizInimigos;
    }

    public void setMatrizInimigos(String[] matrizInimigos) {
        this.matrizInimigos = matrizInimigos;
    }
    
    public String getElemMatrizStrings(int i, int j) {
        return this.matrizStrings[i][j];
    }

    public void setMatrizStrings(String[][] matrizStrings) {
        this.matrizStrings = matrizStrings;
    }
}