package Modelo;

import Auxiliar.Desenho;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Moblin extends Inimigos  implements Serializable{
    
    public Moblin() {
        super("moblinBaixo.png");
        this.setbMortal(true);
        this.setbTransponivel(true);
    }

    public void autoDesenho(){
        Random rand = new Random();
        int iDirecao = rand.nextInt(4)+1;
        
        switch (iDirecao) {
            case 1:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
                validaPosicao();
                try {
                    this.setDesenho("moblinDir.png");
                } catch (IOException ex) {
                    Logger.getLogger(Moblin.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 2:
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                validaPosicao();
                try {
                    this.setDesenho("moblinBaixo.png");
                } catch (IOException ex) {
                    Logger.getLogger(Moblin.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
                validaPosicao();
                try {
                    this.setDesenho("moblinEsq.png");
                } catch (IOException ex) {
                    Logger.getLogger(Moblin.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 4:
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                validaPosicao();
                try {
                    this.setDesenho("moblinCima.png");
                } catch (IOException ex) {
                    Logger.getLogger(Moblin.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
        super.autoDesenho();
    }    
}