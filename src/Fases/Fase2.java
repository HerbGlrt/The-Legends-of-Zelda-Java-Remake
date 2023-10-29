/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fases;

/**
 *
 * @author andre
 */
public class Fase2 {
    static String[][] matriz2 ={{"coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "coracaoCheio.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", "preto.png", }, // LINHA 0
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 1
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 2
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png"}, // LINHA 3
                                {null, null, null, null, null, null, null, "arbusto2.png", null, "arbusto2.png", null, null, null, "arbusto2.png", null, "arbusto2.png", }, // LINHA 4
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png" }, // LINHA 5
                                {null, null, null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png", null, "arbusto2.png" }, // LINHA 6
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png", }, // LINHA 7
                                {null, null, null, null, null, null, null, "arbusto2.png", null, "arbusto2.png", null, null, null, "arbusto2.png", null, "arbusto2.png", }, // LINHA 8
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "arbusto2.png", }, // LINHA 9
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 10
                                {"arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", "arbusto2.png", }, // LINHA 11
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 12
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 13
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 14
                                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, }, // LINHA 15

        };

    public static String[][] getMatriz() {
        return matriz2;
    }
    
    public static String getValor(int i, int j){
        return matriz2[i][j];
    }
    
}
