package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class BichinhoVaiVemHorizontal extends Inimigos  implements Serializable{
    private boolean bRight;

    public BichinhoVaiVemHorizontal(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
        this.setbMortal(true);
        this.setbTransponivel(true);
    }
    public void autoDesenho(){
        SecureRandom rand = new SecureRandom();
        
        int direcao = rand.nextInt(8);
        
        super.autoDesenho();
        
        switch (direcao){
            case 0:
                //this.pPosicao.moveUp();
                this.moveUp();
            case 1:
                this.moveDown();
            case 2:
                this.moveLeft();
            case 3:
                this.moveRight();
            case 4:
                this.moveUp();
            case 5:
                this.moveDown();
            case 6:
                this.moveLeft();
            case 7:
                this.moveRight();
            default:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna());
        }
        this.validaPosicao();
    }
}