package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;
import Controler.Tela;
import java.awt.Graphics;

public class Projetil extends Personagem implements Serializable{
    int i;
    public Projetil(String sNomeImagePNG,int i) {
        super(sNomeImagePNG);
        this.setIsProjetil(true);
        this.setbMortal(true);
        this.setbTransponivel(true);
        this.i=i;
    }

    public void autoDesenho() {
        super.autoDesenho();
        if (i == 0 && !this.moveUp()){ // 0 UP; 1 RIGHT;  2 DOWN;  3 LEFT
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }else if (i == 1 && !this.moveRight()){
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }else if(i == 2 && !this.moveDown()){
            Desenho.acessoATelaDoJogo().removePersonagem(this);
        }else if (i == 3 && !this.moveLeft()){
            Desenho.acessoATelaDoJogo().removePersonagem(this); 
        }
    }
}