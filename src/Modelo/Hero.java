package Modelo;

import Auxiliar.Consts;
import Modelo.Estatico;
import Auxiliar.Desenho;
import Controler.ControleDeJogo;
import Controler.Tela;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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

    public int getOlhando() {
        return olhando;
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
    //5, 7, 9
    public int vida(ArrayList<Personagem> umaFase) throws IOException{
        this.setVida(this.getVida() - 1);
        
        switch(this.getVida()){
            case 2:
                Estatico coracao1  = (Estatico)umaFase.get(9);
                coracao1.setDesenho("coracaoVazio.png");
                break;
            case 1:
                Estatico coracao2  = (Estatico)umaFase.get(7);
                coracao2.setDesenho("coracaoVazio.png");
                break;
             case 0:
                Estatico coracao3  = (Estatico)umaFase.get(5);
                coracao3.setDesenho("coracaoVazio.png");
                break;
        }
        if(this.getVida() == 0){
            return 0;
        }else{
            return 1;
        }
    }
    
    public void autoDesenho(int i){
        super.autoDesenho();
        if (i == 0){
            Projetil espada = new Projetil("espadaCima.png",0);
            espada.setPosicao(pPosicao.getLinha()-1,pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }
        else{
            if (i == 1){
                Projetil espada = new Projetil("espadaDir.png",1);
                espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
                Desenho.acessoATelaDoJogo().addPersonagem(espada);
            }
            else{
                if(i == 2){
                    Projetil espada = new Projetil("espadaBaixo.png",2);
                    espada.setPosicao(pPosicao.getLinha()+1,pPosicao.getColuna());
                    Desenho.acessoATelaDoJogo().addPersonagem(espada);
                }
                else{
                    if (i == 3){
                        Projetil espada = new Projetil("espadaEsq.png",3);
                        espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()-1);
                        Desenho.acessoATelaDoJogo().addPersonagem(espada);
                    }
                }
            }
        }
    }
    
    public void espada(int obj){
        switch (obj){
            case 0:{ // UP
                autoDesenho(0);
                break;
            }
            case 1:{ // RIGHT
                autoDesenho(1);
                break;
            }
            case 2:{ // DOWN
                autoDesenho(2);
                break;
            }
            case 3:{ // LEFT
                autoDesenho(3);
                break;
            }
            default:
                break;
        }
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
