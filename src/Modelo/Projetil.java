package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Projetil extends Personagem implements Serializable{
    int i; // olhando
    int k; // projetil estatico (0) ou dinamico (1)

    public Projetil(String sNomeImagePNG,int i, int k) {
        super(sNomeImagePNG);
        this.setIsProjetil(true);
        this.setbMortal(true);
        this.setbTransponivel(true);
        this.i = i;
        this.k = k;
    }
    
    public void removeProjetil(){
        Desenho.acessoATelaDoJogo().removePersonagem(this);
    }

    public void autoDesenho() {
        super.autoDesenho();
        if (k == 1){
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
}