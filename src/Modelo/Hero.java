package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import Controler.Tela;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hero extends Personagem implements Serializable{
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }

    public void setOlhando(int olhando) {
        this.olhando = olhando;
    }    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }
    
    public void espada(){
        Projetil espada = new Projetil("espada.png");
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
    }

    /*TO-DO: este metodo pode ser interessante a todos os personagens que se movem*/
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public boolean moveUp() {
        if(super.moveUp()){
        try {
            if(this.getCountSprite() == 1){
            this.setDesenho("linkUp.png");
            this.setCountSprite(0);
            }else{
            this.setDesenho("linkUp2.png");
            this.setCountSprite(1);
            }
    }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return validaPosicao();
        }
    return false;
    }

    public boolean moveDown() {
        if(super.moveDown()){
        try {
            if(this.getCountSprite() == 1){
            this.setDesenho("linkDown.png");
            this.setCountSprite(0);
            }else{
            this.setDesenho("linkDown2.png");
            this.setCountSprite(1);
            }
    }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return validaPosicao();
        }
    return false;
    }

    public boolean moveRight() {
        if(super.moveRight()){
        try {
            if(this.getCountSprite() == 1){
            this.setDesenho("linkRight.png");
            this.setCountSprite(0);
            }else{
            this.setDesenho("linkRight2.png");
            this.setCountSprite(1);
            }
    }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return validaPosicao();
        }
    return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft()){
        try {
            if(this.getCountSprite() == 1){
            this.setDesenho("linkLeft.png");
            this.setCountSprite(0);
            }else{
            this.setDesenho("linkLeft2.png");
            this.setCountSprite(1);
            }
    }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return validaPosicao();
        }
    return false;
    }    
    
}
