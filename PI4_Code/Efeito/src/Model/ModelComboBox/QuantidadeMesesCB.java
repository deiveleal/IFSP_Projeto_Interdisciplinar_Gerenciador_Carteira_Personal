/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ModelComboBox;

/**
 *
 * @author carolina
 */
public class QuantidadeMesesCB {

      
    private int quantidadeMeses;
    private double valorPlano;
    private String tipoPlano;

    public QuantidadeMesesCB(int quantidadeMeses, double valorPlano, String tipoPlano) {
        this.quantidadeMeses = quantidadeMeses;
        this.valorPlano = valorPlano;
        this.tipoPlano = tipoPlano;
    }

    public double getValorPlano() {
        return valorPlano;
    }

    public void setValorPlano(double valorPlano) {
        this.valorPlano = valorPlano;
    }
    
    public int getQuantidadeMeses() {
        return quantidadeMeses;
    }

    public void setQuantidadeMeses(int quantidadeMeses) {
        this.quantidadeMeses = quantidadeMeses;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    @Override
    public String toString() {
        return getTipoPlano();
    }
    
    
}
