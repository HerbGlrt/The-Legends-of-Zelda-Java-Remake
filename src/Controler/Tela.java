package Controler;

import Modelo.Personagem;
import Modelo.Octorok;
import Modelo.Hero;
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
    }

       // -----------------------------------------------------------------------------
    
    String[][] matrix = {{"areia.png", "arbusto2.png", "arbusto2.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 0
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 1
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 2
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 3
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 4
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 5
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 6
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 7
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 8
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 9
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 10
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 11
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 12
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 13
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 14
                            {"areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", 
                            "areia.png", "areia.png", "areia.png", "areia.png", }, // LINHA 15
        };
    
    
    // --------------------------------------------------------------------------
    
    public void criar_fase(){
        for(int i = 0; i < 16; i++){
            Estatico obj = new Estatico(matrix[0][1]);
            obj.setPosicao(0, 9);
            this.addPersonagem(obj);
        }
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
                for (int j = 0; j < Consts.RES; j++) {
            try {
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "preto.png");
                g2.drawImage(newImage,  j * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
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
