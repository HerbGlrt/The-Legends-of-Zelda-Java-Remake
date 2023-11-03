package Modelo;

import auxiliar.Posicao;
import java.io.Serializable;

public class Teleport extends Personagem implements Serializable{
    private char key;
    private char destino;
    private int posXDest;
    private int posYDest;
    protected Posicao pPosicao;
    
    public Teleport(char key, char destino, int posXDest, int posYDest) {
        super("transparente.png");
        this.setbMortal(false);
        this.setbTransponivel(true);
        this.setKey(key);
        this.setDestino(destino);
        this.setPosXDest(posXDest);
        this.setPosYDest(posYDest);
    }
    
        public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }
        
    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public char getDestino() {
        return destino;
    }

    public void setDestino(char destino) {
        this.destino = destino;
    }

    public int getPosXDest() {
        return posXDest;
    }

    public void setPosXDest(int posXDest) {
        this.posXDest = posXDest;
    }

    public int getPosYDest() {
        return posYDest;
    }

    public void setPosYDest(int posYDest) {
        this.posYDest = posYDest;
    }
}
