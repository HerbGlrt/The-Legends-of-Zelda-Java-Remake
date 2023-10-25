package Controler;

import Modelo.Personagem;
import Modelo.Octorok;
import Modelo.Hero;
import Modelo.Estatico;
import Modelo.BichinhoVaiVemHorizontal;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.ZigueZague;
import auxiliar.Posicao;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;


public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hero;
    private ArrayList<Personagem> faseAtual;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    private int idelay;

    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/

        this.addKeyListener(this);   /*teclado*/
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>();

        /*Cria faseAtual adiciona personagens*/
        hero = new Hero("linkDown.png");
        hero.setPosicao(5, 5);
        this.addPersonagem(hero);
        
        ZigueZague zz = new ZigueZague("octorok.png");
        zz.setPosicao(9, 9);
        this.addPersonagem(zz);

        BichinhoVaiVemHorizontal bBichinhoH = new BichinhoVaiVemHorizontal("octorok.png");
        bBichinhoH.setPosicao(5, 12);
        this.addPersonagem(bBichinhoH);

        BichinhoVaiVemHorizontal bBichinhoH2 = new BichinhoVaiVemHorizontal("octorok.png");
        bBichinhoH2.setPosicao(4, 12);
        this.addPersonagem(bBichinhoH2);

        Octorok bV = new Octorok("octorok.png");
        bV.setPosicao(9, 1);
        this.addPersonagem(bV);
        
        Estatico b1 = new Estatico("coracaoCheio.png");
        b1.setIsCoracao(1);
        b1.setPosicao(0,0);
        this.addPersonagem(b1);
        Estatico b2 = new Estatico("preto.png");
        b2.setPosicao(0,1);
        this.addPersonagem(b2);
        Estatico b3 = new Estatico("coracaoCheio.png");
        b3.setIsCoracao(1);
        b3.setPosicao(0,2);
        this.addPersonagem(b3);
        Estatico b4 = new Estatico("preto.png");
        b4.setPosicao(0,3);
        this.addPersonagem(b4);
        Estatico b5 = new Estatico("coracaoCheio.png");
        b5.setIsCoracao(1);
        b5.setPosicao(0,4);
        this.addPersonagem(b5);
        Estatico b6 = new Estatico("preto.png");
        b6.setPosicao(0,5);
        this.addPersonagem(b6);
        Estatico b7 = new Estatico("preto.png");
        b7.setPosicao(0,6);
        this.addPersonagem(b7);
        Estatico b8 = new Estatico("preto.png");
        b8.setPosicao(0,7);
        this.addPersonagem(b8);
        Estatico b9 = new Estatico("preto.png");
        b9.setPosicao(0,8);
        this.addPersonagem(b9);
        Estatico b10 = new Estatico("preto.png");
        b10.setPosicao(0,9);
        this.addPersonagem(b10);
        Estatico b11 = new Estatico("preto.png");
        b11.setPosicao(0,10);
        this.addPersonagem(b11);
        Estatico b12 = new Estatico("preto.png");
        b12.setPosicao(0,11);
        this.addPersonagem(b12);
        Estatico b13 = new Estatico("preto.png");
        b13.setPosicao(0,12);
        this.addPersonagem(b13);
        Estatico b14 = new Estatico("preto.png");
        b14.setPosicao(0,13);
        this.addPersonagem(b14);
        Estatico b15 = new Estatico("preto.png");
        b15.setPosicao(0,14);
        this.addPersonagem(b15);
        Estatico b16 = new Estatico("preto.png");
        b16.setPosicao(0,15);
        this.addPersonagem(b16);
    }

    public boolean ehPosicaoValida(Posicao p){
        return cj.ehPosicaoValida(this.faseAtual, p);
    }
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "areia.png");
                    g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            this.cj.processaTudo(faseAtual);
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }
    
    public void keyPressed(KeyEvent e) {
        if(idelay == 0){
            idelay = 0;
            switch (e.getKeyCode()) {
                case KeyEvent.VK_C:
                    this.faseAtual.clear();
                    break;
                case KeyEvent.VK_UP:
                    hero.setOlhando(0);
                    hero.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    hero.setOlhando(2);
                    hero.moveDown();
                    break;
                case KeyEvent.VK_LEFT:
                    hero.setOlhando(3);
                    hero.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    hero.setOlhando(1);
                    hero.moveRight();
                    break;
                case KeyEvent.VK_A:
                    hero.espada(hero.getOlhando());
                    break;
                default:
                    break;
            }
        this.setTitle("-> Cell: " + (hero.getPosicao().getColuna()) + ", "
                + (hero.getPosicao().getLinha()));
        }else{
            idelay++;
        }
        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
