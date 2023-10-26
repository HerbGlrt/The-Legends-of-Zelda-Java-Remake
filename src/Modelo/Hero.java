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


    public void setOlhando(int olhando) {
        this.olhando = olhando;
    }

    public int getOlhando() {
        return olhando;
    }
    
    public int vida(ArrayList<Personagem> umaFase) throws IOException{
        this.setVida(this.getVida() - 1);
        
        switch(this.getVida()){
            case 2:
                Estatico coracao1  = (Estatico)umaFase.get(8);
                coracao1.setDesenho("coracaoVazio.png");
                break;
            case 1:
                Estatico coracao2  = (Estatico)umaFase.get(6);
                coracao2.setDesenho("coracaoVazio.png");
                break;
             case 0:
                Estatico coracao3  = (Estatico)umaFase.get(4);
                coracao3.setDesenho("coracaoVazio.png");
                break;
        }
        if(this.getVida() == 0){
            return 0;
        }else{
            return 1;
        }
    }
    
    public void autoDesenho(int i){ // Função que desenha a espada para ataque à distância
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
    
    public void espada(int obj) throws IOException{    //Função para decidir qual ataque o link fará
        switch (obj){
            case 0:{ // UP
                if(getVida() == 3){
                autoDesenho(0);
                this.setDesenho("linkAtkC1.png");
                }
                break;
            }
            case 1:{ // RIGHT
                if(getVida() == 3){
                autoDesenho(1);
                this.setDesenho("linkAtkD1.png");
                }
                break;
            }
            case 2:{ // DOWN
                if(getVida() == 3){
                autoDesenho(2);
                this.setDesenho("linkAtkB1.png");
                }
                break;
            }
            case 3:{ // LEFT
                if(getVida() == 3){
                autoDesenho(3);
                this.setDesenho("linkAtkE1.png");
                }
                break;
            }
            default:
                break;
        }
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
