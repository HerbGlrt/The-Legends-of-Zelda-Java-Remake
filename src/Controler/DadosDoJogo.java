package Controler;

import Modelo.Personagem;
import auxiliar.Posicao;
import java.io.Serializable;
import java.util.ArrayList;

public class DadosDoJogo implements Serializable{
    
    Posicao pPosicao;
    public int olhando;           // Qual lado está olhando: Cima(0), Direita(1), Baixo(2), Esquerda(3)
    //public boolean temEspada = false; // cooldown da espada
    int vida = 3; // Vida do personagem
    ArrayList<Personagem> fase;
    
}
