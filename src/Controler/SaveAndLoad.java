package Controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndLoad {
    Tela tela;
    
    public SaveAndLoad(Tela tela){
        this.tela = tela;
    }
    
    public void save(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DadosDoJogo ds = new DadosDoJogo();
            
            ds.olhando = tela.getFaseAtual().get(0).getOlhando();
            ds.pPosicao = tela.getFaseAtual().get(0).getPosicao();
            ds.vida = tela.getFaseAtual().get(0).getVida();
            ds.fase = tela.getFaseAtual();
            
            out.writeObject(ds);
            
        }
        catch(Exception e){
            System.out.println("Save Exception!");
        }
        
    }
    
    public void load(){
        
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            
            // Leitura dos Dados do jogo
            
            DadosDoJogo ds = (DadosDoJogo) in.readObject();
            
            tela.getFaseAtual().get(0).setOlhando(ds.olhando);
            tela.getFaseAtual().get(0).setPosicao(ds.pPosicao.getLinha(), ds.pPosicao.getColuna());
            tela.getFaseAtual().get(0).setVida(ds.vida);
            tela.setFaseAtual(ds.fase);
        }
        catch (Exception e){
            System.out.println("Load Exception!");
        }
        
        
    }
    
}
