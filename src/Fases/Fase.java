/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andre
 */
public abstract class Fase {
    private String[][] matrix;
    
    public void setMatrix(String[][] matrix){
        this.matrix = matrix;
    }
    
    public String[][] getMatrix(){
        return matrix;
    }
}
