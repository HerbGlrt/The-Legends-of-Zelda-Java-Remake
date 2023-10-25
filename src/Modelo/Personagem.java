package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Personagem implements Serializable {

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected int olhando;           // Qual lado está olhando: Cima(0), Direita(1), Baixo(2), Esquerda(3)
    protected boolean isProjetil = false;   // O personagem é um projétil?
    protected int isCoracao = 0;   // O personagem é um coração? (0 = Não, 1 = Coração cheio, 2 = Coração vazio)
    protected int countSprite = 0;    // Contador para mudar os sprites de animalçao do personagem
    protected int vida = 3; // Vida do personagem

    protected Personagem(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        try {
            setDesenho(sNomeImagePNG);
    }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setDesenho(String sNomeImagePNG)throws IOException{
        iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
        Image img = iImage.getImage();
        BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
        iImage = new ImageIcon(bi);    
    } 

    public boolean getsIsProjetil() {
        return isProjetil;
    }

    public void setIsProjetil(boolean isProjetil) {
        this.isProjetil = isProjetil;
    }

    public int getIsCoracao() {
        return isCoracao;
    }

    public void setIsCoracao(int isCoracao) {
        this.isCoracao = isCoracao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getCountSprite() {
        return countSprite;
    }

    public void setCountSprite(int countSprite) {
        this.countSprite = countSprite;
    }
    public int getOlhando() {
        return olhando;
    }
    
    public Posicao getPosicao() {
        /*TODO: Retirar este método para que objetos externos nao possam operar
         diretamente sobre a posição do Personagem*/
        return pPosicao;
    }

    public boolean getbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public void setbMortal(boolean bMortal) {
        this.bMortal = bMortal;
    }

    public boolean getbMortal() {
        return bMortal;
    }
        
    public void autoDesenho(){
        Desenho.desenhar(this.iImage, this.pPosicao.getColuna(), this.pPosicao.getLinha());        
    }

    public boolean setPosicao(int linha, int coluna) {
        
        return pPosicao.setPosicao(linha, coluna);
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
}
