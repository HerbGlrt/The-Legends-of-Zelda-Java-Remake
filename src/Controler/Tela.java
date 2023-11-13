package Controler;

import Fases.Fase;
import Modelo.Personagem;
import Modelo.Octorok;
import Modelo.Hero;
import Modelo.Estatico;
import Modelo.Lynel;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Fases.Fase1;
import Fases.Fase2;
import Fases.Fase3;
import Fases.Fase4;
import Fases.FaseBonus;
import Modelo.Teleport;
import Modelo.Moblin;
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

public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener{

    private Hero hero;
    private ArrayList<Personagem> faseAtual;
    public Estatico[][] parede = new Estatico[16][16];
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    private int constDelay = 1;
    private int idelay = constDelay;
    private static int fundo = 0;
    private SaveAndLoad s;

    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this);
        /*mouse*/

        this.addKeyListener(this);
        /*teclado*/
 /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right, (Consts.RES - 4) * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        faseAtual = new ArrayList<Personagem>();

        //Cria faseAtual adiciona personagens
        hero = new Hero("linkDown.png");
        this.addPersonagem(hero);
        hero.setPosicao(6,1);
        
        s = new SaveAndLoad(this);
    }

    public boolean ehPosicaoValida(Posicao p) {
        return cj.ehPosicaoValida(this.faseAtual, p);
    }
    
    public ArrayList<Personagem> getFaseAtual(){
        return faseAtual;
    }
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer() {
        return g2;
    }
    
    public void setFaseAtual(ArrayList<Personagem> faseAtual) {
        this.faseAtual = faseAtual;
    }
    
    public void criaFase(Teleport tp){
        if(tp.getDestino() == 'a' || tp.getDestino() == 'i' || tp.getDestino() == 'h'){ // Analisa qual a fase a ser criada
            Fase.setMatrizStrings(Fase1.getMatrizStrings());
            Fase.setArrayTeleports(Fase1.getArrayTeleports());
            Fase.setArrayInimigos(Fase1.getArrayInimigos());
            Fase.setFase(1);
            fundo = 0;
        }else if(tp.getDestino() == 'g' || tp.getDestino() == 'f'){
            Fase.setMatrizStrings(Fase2.getMatrizStrings());
            Fase.setArrayTeleports(Fase2.getArrayTeleports());
            Fase.setArrayInimigos(Fase2.getArrayInimigos());
            Fase.setFase(2);
            fundo = 0;        
        }else if(tp.getDestino() == 'e' || tp.getDestino() == 'd'){
            Fase.setMatrizStrings(Fase3.getMatrizStrings());
            Fase.setArrayTeleports(Fase3.getArrayTeleports());
            Fase.setArrayInimigos(Fase3.getArrayInimigos());
            Fase.setFase(3);
            fundo = 0;        
        }else if(tp.getDestino() == 'c' || tp.getDestino() == 'b'){
            Fase.setMatrizStrings(Fase4.getMatrizStrings());
            Fase.setArrayTeleports(Fase4.getArrayTeleports());
            Fase.setArrayInimigos(Fase4.getArrayInimigos());
            Fase.setFase(4);
            fundo = 0;        
        }else if(tp.getDestino() == 'j'){
            Fase.setMatrizStrings(FaseBonus.getMatrizStrings());
            Fase.setArrayTeleports(FaseBonus.getArrayTeleports());
            Fase.setArrayInimigos(FaseBonus.getArrayInimigos());
            fundo = 1;        
        }
        hero.setPosicao(tp.getPosXDest(), tp.getPosYDest());    // Seta a posicao do heroi na nova fase
        
         for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                if(Fase.getElemMatrizStrings(i, j) != null){
                    parede[i][j] = new Estatico(Fase.getElemMatrizStrings(i,j));
                    parede[i][j].setPosicao(i,j);
                    addPersonagem(parede[i][j]);
                }
            }
        }
         
        for(int i = 0; i < (int)Fase.getElemArrayTeleport(0); i++){  // Percorre o array de teleport de acordo com a quantidade de TP's por fase
            int pos = i * 6;
            Teleport teleporter = new Teleport(Fase.getElemArrayTeleport(pos + 1), Fase.getElemArrayTeleport(pos + 2), (int)Fase.getElemArrayTeleport(pos + 3), (int)Fase.getElemArrayTeleport(pos + 4));
            if(teleporter.getKey() == 'i'){
                try {
                    teleporter.setDesenho("preto.png");
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            teleporter.setPosicao((int)Fase.getElemArrayTeleport(pos + 5), (int)Fase.getElemArrayTeleport(pos + 6));
            addPersonagem(teleporter);
        }            
        
        for(int i = 0; i < Fase.getElemArrayInimigos(0); i++){
            int pos = i * 4;
            if(Fase.getElemArrayInimigos(pos + 1) == 1){
            switch(Fase.getElemArrayInimigos(pos + 2)){
                case 0:
                    Octorok inimigo0 = new Octorok();
                    inimigo0.setPosicao(Fase.getElemArrayInimigos(pos + 3), Fase.getElemArrayInimigos(pos + 4));
                     faseAtual.add(inimigo0);
                    break;
                case 1:
                    Moblin inimigo1 = new Moblin();
                    inimigo1.setPosicao(Fase.getElemArrayInimigos(pos + 3), Fase.getElemArrayInimigos(pos + 4));
                    faseAtual.add(inimigo1);
                    break;
                case 2:
                    Lynel inimigo2 = new Lynel();
                    inimigo2.setPosicao(Fase.getElemArrayInimigos(pos + 3), Fase.getElemArrayInimigos(pos + 4));
                    faseAtual.add(inimigo2);
                    break;
                }
            }
        }
    }
    
    public void apagaTudo() {
        Fase.setMatrizStrings(null);  // Define a matriz de strings da fase como sendo nula
        Fase.setArrayTeleports(null);   // Define o array de teleports da fase como sendo nulo
        Fase.setArrayInimigos(null);  // Define o array de inimigos da fase como sendo nulo
        for(int i = 0; i < Consts.RES; i++){
            for(int j = 0; j < Consts.RES; j++){
                parede[i][j] = null;    // Percorre toda a matriz de objetos da fase, definindo objeto a objeto como nulo
            }
        }
        ArrayList<Personagem> faseCopia =  (ArrayList<Personagem>) faseAtual.clone();
        Hero h = (Hero)faseAtual.get(0);
        faseCopia.add(h);
        for(int i = 1; i < Consts.RES+1; i++){
            Estatico e = (Estatico)faseAtual.get(i);
            faseCopia.add(e);
        }
        faseAtual.clear();
        for(int i = 0; i <= 16; i++){
            faseAtual.add(faseCopia.get(i));
        }
        faseCopia.clear();
    }

       public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /**
         * ***********Desenha cenário de fundo*************
         */
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    if(fundo == 0){ // Variavel fundo decide se o cenário será de "areia" ou de "preto" dependendo de onde o hero esta
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "areia.png");
                        g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }else {
                        Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "preto.png");
                        g2.drawImage(newImage, j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (!this.faseAtual.isEmpty()) {
            this.cj.desenhaTudo(faseAtual);
            try {
                this.cj.processaTudo(faseAtual);
                if (idelay == 2 && hero.getVida() <= 2 && hero.getTemEspada()){
                    if ((faseAtual.get(faseAtual.size()-1)).getsIsProjetil()){
                        Desenho.acessoATelaDoJogo().removePersonagem(faseAtual.get(faseAtual.size()-1));
                    }
                    if ((faseAtual.get(faseAtual.size()-1)).getsIsProjetil()){
                        Desenho.acessoATelaDoJogo().removePersonagem(faseAtual.get(faseAtual.size()-1));
                    }
                    hero.setTemEspada(false);
                    faseAtual.get(7).setDesenho("espadaHUD.png");
                }
                if (idelay == 4 && hero.getVida() == 3){
                    hero.setTemEspada(false);
                    faseAtual.get(7).setDesenho("espadaHUD.png");
                }
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
        if (idelay < 20) {
            idelay++;
        }
        if(cj.getTp() != null){
            apagaTudo();
            criaFase(cj.getTp());
            cj.setTp(null);
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

        Teleport tp = new Teleport('b', 'a', 6, 1); // Fase 1
        for(int i = 0; i < Consts.RES; i++){
            Estatico cabecalho = new Estatico("preto.png");
            if(i == 0 || i == 2 || i == 4){
                try {
                    cabecalho.setIsCoracao(1);  // Se for um sprite de coração, seta isCoracao
                    cabecalho.setDesenho("coracaoCheio.png");
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(i == 6){
                try {
                    cabecalho.setDesenho("espadaHUD.png");
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cabecalho.setPosicao(0, i);
            addPersonagem(cabecalho);
        }

        criaFase(tp);   // Cria a primeira fase
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            try {
                if (hero.getTemEspada() == false){
                    if (hero.getVida() == 3){
                        hero.espada(hero.getOlhando(), 0);
                    } else{
                        hero.espada(hero.getOlhando(), 1);
                    }
                    faseAtual.get(7).setDesenho("espadaHUDCinza.png");
                }
                idelay = constDelay;
                
            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
            hero.setTemEspada(true);
        } else if (e.getKeyCode() == KeyEvent.VK_UP && idelay >= constDelay) {
            idelay = 0;
            hero.setOlhando(0);
            hero.moveUp();
            if (hero.getTemEspada() && hero.getVida() <= 2 && (faseAtual.get(faseAtual.size()-1)).getsIsProjetil()){
                Desenho.acessoATelaDoJogo().removePersonagem(faseAtual.get(faseAtual.size()-1));
                hero.setTemEspada(false);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && idelay >= constDelay) {
            idelay = 0;
            hero.setOlhando(2);
            hero.moveDown();
            if (hero.getTemEspada() && hero.getVida() <= 2 && (faseAtual.get(faseAtual.size()-1)).getsIsProjetil()){
                Desenho.acessoATelaDoJogo().removePersonagem(faseAtual.get(faseAtual.size()-1));
                hero.setTemEspada(false);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && idelay >= constDelay) {
            idelay = 0;
            hero.setOlhando(3);
            hero.moveLeft();
            if (hero.getTemEspada() && hero.getVida() <= 2 && (faseAtual.get(faseAtual.size()-1)).getsIsProjetil()){
                Desenho.acessoATelaDoJogo().removePersonagem(faseAtual.get(faseAtual.size()-1));
                hero.setTemEspada(false);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && idelay >= constDelay) {
            idelay = 0;
            hero.setOlhando(1);
            hero.moveRight();
            if (hero.getTemEspada() && hero.getVida() <= 2 && (faseAtual.get(faseAtual.size()-1)).getsIsProjetil()){
                Desenho.acessoATelaDoJogo().removePersonagem(faseAtual.get(faseAtual.size()-1));
                hero.setTemEspada(false);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S){
            s.save();
            System.out.println("Jogo salvo!");
            
        } else if (e.getKeyCode() == KeyEvent.VK_L){
            s.load();
            hero = (Hero) faseAtual.get(0);
            System.out.println("Jogo carregado");
        }
        this.setTitle("-> Cell: " + (hero.getPosicao().getColuna()) + ", " + (hero.getPosicao().getLinha()));
    }
    //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
        int x = e.getX();
        int y = e.getY();

        this.setTitle("X: " + x + ", Y: " + y
                + " -> Cell: " + (y / Consts.CELL_SIDE) + ", " + (x / Consts.CELL_SIDE));

        this.hero.getPosicao().setPosicao(y / Consts.CELL_SIDE, x / Consts.CELL_SIDE);

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
