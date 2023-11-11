package Controler;

import Modelo.Personagem;
import Modelo.Hero;
import Modelo.Projetil;
import Modelo.Teleport;
import auxiliar.Posicao;
import java.io.IOException;
import java.util.ArrayList;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            if(e.get(i) instanceof Projetil){
                e.get(i).autoDesenho();
            }
            else{
                e.get(i).autoDesenho();
            }
        }
    }
    public Teleport tp = null;  // Variavel que mostra em qual teleport o hero subiu
    public Teleport getTp() {
        return tp;
    }

    public void setTp(Teleport tp) {
        this.tp = tp;
    }
    
    
    public void processaTudo(ArrayList<Personagem> umaFase) throws IOException{
        Hero hero = (Hero)umaFase.get(0);
        Projetil espada = null;
        Personagem pIesimoPersonagem;
         for(int i = 1; i < umaFase.size(); i++){
             pIesimoPersonagem = umaFase.get(i);
             if(!pIesimoPersonagem.getIsEspada()){
                espada = (Projetil) pIesimoPersonagem;    // se o pIesimoPersonagem for do tipo espada, salva ele como espada
            }
         }
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(espada != null && hero.getTemEspada() && pIesimoPersonagem.getIsEspada() == false  && pIesimoPersonagem.getbMortal() == true){
                if(espada.getPosicao().igual(pIesimoPersonagem.getPosicao())){
                        umaFase.remove(pIesimoPersonagem);
                        umaFase.remove(espada);
                }
            }
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()) && pIesimoPersonagem instanceof Teleport){
                if (hero.vida(umaFase) == 0){
                   System.exit(0);
                }
                if(pIesimoPersonagem instanceof Projetil){
                    umaFase.remove(pIesimoPersonagem);
                }
            }
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()) && pIesimoPersonagem instanceof Teleport){
                setTp((Teleport)pIesimoPersonagem); // Se o hero subiu em algum teleport, será visto na paint e a fase trocada
                }
        }              
    }
    
    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.getbTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
    
}
