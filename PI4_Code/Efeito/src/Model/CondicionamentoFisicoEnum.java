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
public enum CondicionamentoFisicoEnum {
    INICIANTE("iniciante"),
    INTERMEDIARIO("intermediario"),
    AVANÇADO("avançado");
    
    private String condicionamento;
    
    CondicionamentoFisicoEnum(String condicionamento){
        this.condicionamento = condicionamento;
    }
    
    public String getSexoEnum(){
        return condicionamento;
    }
    
}
