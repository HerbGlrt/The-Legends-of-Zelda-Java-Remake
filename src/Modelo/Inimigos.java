package Modelo;

public abstract class Inimigos extends Personagem{
    private boolean isBoss = false;
    
    public Inimigos(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public boolean GetIsBoss() {
        return isBoss;
    }

    public void setIsBoss(boolean isBoss) {
        this.isBoss = isBoss;
    }
    
    public boolean moveUp() {
        if(super.moveUp()){
            return validaPosicao();
        }
    return false;
    }

    public boolean moveDown() {
        if(super.moveDown()){
        return validaPosicao();
        }
    return false;
    }

    public boolean moveRight() {
        if(super.moveRight()){
        return validaPosicao();
        }
    return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft()){
        return validaPosicao();
        }
    return false;
    }
    
}