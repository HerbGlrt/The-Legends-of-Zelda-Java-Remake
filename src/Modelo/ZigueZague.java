package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;
import java.util.Random;

public class ZigueZague extends Inimigos  implements Serializable{
    
    public ZigueZague(String sNomeImagePNG) {
        super(sNomeImagePNG);
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
                break;
            case 2:
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                validaPosicao();
                break;
            case 3:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
                validaPosicao();
                break;
            case 4:
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                validaPosicao();
                break;
            default:
                break;
        }
        super.autoDesenho();
    }    
}