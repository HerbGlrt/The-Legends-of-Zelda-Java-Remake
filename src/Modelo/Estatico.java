package Modelo;

import java.io.Serializable;

public abstract class Estatico extends Personagem implements Serializable{

    public Estatico(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.setbMortal(false);
        this.setbTransponivel(false);
    }

    
    
}
