package Controler;

import Modelo.Personagem;
import Modelo.Hero;
import Modelo.Projetil;
import auxiliar.Posicao;
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
    
    public void processaTudo(ArrayList<Personagem> umaFase){
        Hero hero = (Hero)umaFase.get(0);
        Personagem espada = umaFase.get(umaFase.size() - 1);    // temp será o último personagem criado, possivelmente uma epsada do heroi
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(espada.getsIsProjetil() == true && pIesimoPersonagem.getsIsProjetil() == false && espada.getPosicao().igual(pIesimoPersonagem.getPosicao())){
                if(pIesimoPersonagem.getbTransponivel()){
                    if(pIesimoPersonagem.getbMortal())   // Checa se o personagem é mortal antes de retira-lo;
                        umaFase.remove(pIesimoPersonagem);
                        umaFase.remove(umaFase.size() - 1);
                }
            }
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao())){
                if (hero.vida(umaFase) == 0){
                    umaFase.remove(hero);
                }
                if(pIesimoPersonagem.getsIsProjetil() == true){
                    umaFase.remove(pIesimoPersonagem);
                }
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
