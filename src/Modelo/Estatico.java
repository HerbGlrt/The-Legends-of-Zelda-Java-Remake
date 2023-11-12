package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Estatico extends Personagem implements Serializable{

    public Estatico(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.setbMortal(false);
        this.setbTransponivel(false);
        
        if("carne.png".equals(sNomeImagePNG)){
            this.setbTransponivel(true);
            this.setIsCarne(true);
        }
    }
    
}
