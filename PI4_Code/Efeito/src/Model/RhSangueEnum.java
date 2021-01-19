/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author deive
 */
public enum RhSangueEnum {
    POSITIVO("Positivo"), 
    NEGATIVO("Negativo");
    
    private String TipoSangue;
    
    RhSangueEnum(String TipoSangue){
        this.TipoSangue = TipoSangue;
    }
    
    public String getRhSangue(){
        return TipoSangue;
    }
}
