package Modelo;

import java.io.Serializable;

public class Lynel extends Inimigos  implements Serializable{
    private int deltax;
    private int deltay;
    private int delay;
    
    public Lynel() {
        super("lynelBaixo.png");
        this.setbMortal(true);
        this.setbTransponivel(true);
    }
 
    public void deltaCoord(int hx, int hy){
        deltax = this.getLinha() - hx;
        deltay = this.getColuna() - hy;
    }
    
    public void autoDesenhoLynel(Hero hero){
        delay++;
        this.deltaCoord(hero.getLinha(), hero.getColuna());
        
        if(deltax < 0 && delay == 2){
            this.setPosicao(this.getLinha()+1, this.getColuna());
            this.validaPosicao();
            delay = 0;
        }if(deltax > 0 && delay == 2){
            this.setPosicao(this.getLinha()-1, this.getColuna());
            this.validaPosicao();
            delay = 0;
        }if(deltay < 0 && delay == 2){
            this.setPosicao(this.getLinha(), this.getColuna()+1);
            this.validaPosicao();
            delay = 0;
        }if(deltay > 0 && delay == 2){
            this.setPosicao(this.getLinha(), this.getColuna()-1);
            this.validaPosicao();
            delay = 0;
        }
        super.autoDesenho();
    }
}