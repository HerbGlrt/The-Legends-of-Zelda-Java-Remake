package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Serializable;

public class Octorok extends Inimigos implements Serializable{
     private int iContaIntervalos;
    
    public Octorok(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.iContaIntervalos = 0;
        this.setbMortal(true);
        this.setbTransponivel(true);
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER){
            this.iContaIntervalos = 0;
            Projetil f = new Projetil("rok.png", 1, 1);
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            Desenho.acessoATelaDoJogo().addPersonagem(f);
        }

    }
    
    public void autoDesenhoEstatico(){
        super.autoDesenho();
    }
    
}