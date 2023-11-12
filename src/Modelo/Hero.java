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
    
    public int vida(ArrayList<Personagem> umaFase, int mode) throws IOException{    // Mode == 0, perde vida. Mode == 1, ganha vida.
        if(mode == 0){
            this.setVida(this.getVida() - 1);
        }else{
            this.setVida(this.getVida() + 1);
        }
        
        Estatico coracao1  = (Estatico)umaFase.get(5);
        Estatico coracao2  = (Estatico)umaFase.get(3);
        Estatico coracao3  = (Estatico)umaFase.get(1);
        switch(this.getVida()){
            case 3:
                coracao1.setDesenho("coracaoCheio.png");
                coracao2.setDesenho("coracaoCheio.png");
                coracao3.setDesenho("coracaoCheio.png");
                break;
            case 2:
                coracao1.setDesenho("coracaoVazio.png");
                coracao2.setDesenho("coracaoCheio.png");
                coracao3.setDesenho("coracaoCheio.png");
                break;
            case 1:
                coracao1.setDesenho("coracaoVazio.png");
                coracao2.setDesenho("coracaoVazio.png");
                coracao3.setDesenho("coracaoCheio.png");
                break;
             case 0:
                coracao1.setDesenho("coracaoVazio.png");
                coracao2.setDesenho("coracaoVazio.png");
                coracao3.setDesenho("coracaoVazio.png");
                break;
        }
        if(this.getVida() == 0){
            return 0;
        }else{
            return 1;
        }
    }
    // i = olhando, j = 3 vidas ou menos
    public void autoDesenho(int i, int j){ // Função que desenha a espada para ataque à distância
        super.autoDesenho();
        if (j == 0){ // (Se link tem 3 vidas)
            if (i == 0 && (pPosicao.getLinha()-1) > 0){
            Projetil espada = new Projetil("espadaCima.png",0, 1);
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }else if (i == 1 && (pPosicao.getColuna()+1) < Auxiliar.Consts.RES){
            Projetil espada = new Projetil("espadaDir.png",1, 1);
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }else if(i == 2 && (pPosicao.getLinha()+1) < Auxiliar.Consts.RES){
            Projetil espada = new Projetil("espadaBaixo.png",2, 1);
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);

        }else if (i == 3 && (pPosicao.getColuna()-1) > 0){
            Projetil espada = new Projetil("espadaEsq.png",3, 1);
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }
        }
        else{ // Se link tem menos de 3 vidas
            if (i == 0 && (pPosicao.getLinha()-1) > 0){
            Projetil espada = new Projetil("espadaCima.png",0, 0);
            espada.setPosicao(pPosicao.getLinha()-1,pPosicao.getColuna());
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }else if (i == 1 && (pPosicao.getColuna()+1) < Auxiliar.Consts.RES){
            Projetil espada = new Projetil("espadaDir.png",1, 0);
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }else if(i == 2 && (pPosicao.getLinha()+1) < Auxiliar.Consts.RES){
                Projetil espada = new Projetil("espadaBaixo.png",2, 0);
                espada.setPosicao(pPosicao.getLinha()+1,pPosicao.getColuna());
                espada.setIsEspada(true);
                Desenho.acessoATelaDoJogo().addPersonagem(espada);
        }else if (i == 3 && (pPosicao.getColuna()-1) > 0){
            Projetil espada = new Projetil("espadaEsq.png",3, 0);
            espada.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()-1);
            espada.setIsEspada(true);
            Desenho.acessoATelaDoJogo().addPersonagem(espada);
            }    
        }
        
    }
    
    
    public void espada(int i, int aux) throws IOException{    //Função para decidir qual ataque o link fará
            setTemEspada(true);
            switch (i){ // i = olhando
            case 0:{ // UP
                autoDesenho(i, aux);
                this.setDesenho("linkAtkC1.png");
                break;
            }
            case 1:{ // RIGHT
                autoDesenho(i, aux);
                this.setDesenho("linkAtkD1.png");
                break;
            }
            case 2:{ // DOWN
                autoDesenho(i, aux);
                this.setDesenho("linkAtkB1.png");
                break;
            }
            case 3:{ // LEFT
                autoDesenho(i, aux);
                this.setDesenho("linkAtkE1.png");
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
