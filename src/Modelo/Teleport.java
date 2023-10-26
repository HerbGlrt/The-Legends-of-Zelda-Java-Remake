package Modelo;

import java.io.Serializable;

public class Teleport extends Personagem implements Serializable{
    protected int destino;
    protected int offset;
    
    public Teleport(int dest, int off) {
        super("transparente.png");
        this.setbMortal(false);
        this.setbTransponivel(true);
        this.setDestino(dest);
        this.setOffset(off);
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
