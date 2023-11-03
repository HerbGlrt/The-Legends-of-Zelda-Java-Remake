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

public class BichinhoVaiVemHorizontal extends Personagem  implements Serializable{
    private boolean bRight;

    public BichinhoVaiVemHorizontal(String sNomeImagePNG) {
        super(sNomeImagePNG);
        bRight = true;
        this.setbMortal(true);
        this.setbTransponivel(true);
    }
    public void autoDesenho(){
        if(bRight)
            //this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
            this.pPosicao.moveRight();
        else
            //this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           
            this.pPosicao.moveLeft();

        super.autoDesenho();
        bRight = !bRight;
    }
}