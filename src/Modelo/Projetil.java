package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;
import Controler.Tela;
import java.awt.Graphics;

public class Projetil extends Personagem implements Serializable{
    public Projetil(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.setIsProjetil(true);
        this.setbMortal(true);
        this.setbTransponivel(true);
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
    
}