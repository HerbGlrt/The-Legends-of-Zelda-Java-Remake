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

public class Lynel extends Inimigos  implements Serializable{

    public Lynel() {
        super("lynelBaixo.png");
        this.setbMortal(true);
        this.setbTransponivel(true);
    }
    public void autoDesenho(){
        
        this.validaPosicao();
        super.autoDesenho();
    }
}