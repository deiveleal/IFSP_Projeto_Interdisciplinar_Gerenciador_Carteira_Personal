/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ModelEnum;

/**
 *
 * @author deive
 */
public enum SexoEnum {
    MASCULINO("masculino"),
    FEMININO("feminino"),
    NAOBINARIO("não-binario");
    
    private String TipoSexo;
    
    SexoEnum(String TipoSexo){
        this.TipoSexo = TipoSexo;
    }
    
    public String getSexoEnum(){
        return TipoSexo;
    }
}
