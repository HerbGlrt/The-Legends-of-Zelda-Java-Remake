package Modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
                this.setDesenho("lynelBaixo.png");
            } catch (IOException ex) {
                Logger.getLogger(Lynel.class.getName()).log(Level.SEVERE, null, ex);
            }
            delay = 0;
        }if(deltax > 0 && delay == 2){
            this.setPosicao(this.getLinha()-1, this.getColuna());
            this.validaPosicao();
            try {
                this.setDesenho("lynelCima.png");
            } catch (IOException ex) {
                Logger.getLogger(Lynel.class.getName()).log(Level.SEVERE, null, ex);
            }
            delay = 0;
        }if(deltay < 0 && delay == 2){
            this.setPosicao(this.getLinha(), this.getColuna()+1);
            this.validaPosicao();
            try {
                this.setDesenho("lynelDir.png");
            } catch (IOException ex) {
                Logger.getLogger(Lynel.class.getName()).log(Level.SEVERE, null, ex);
            }
            delay = 0;
        }if(deltay > 0 && delay == 2){
            this.setPosicao(this.getLinha(), this.getColuna()-1);
            this.validaPosicao();
            try {
                this.setDesenho("lynelEsq.png");
            } catch (IOException ex) {
                Logger.getLogger(Lynel.class.getName()).log(Level.SEVERE, null, ex);
            }
            delay = 0;
        }
        super.autoDesenho();
    }
}