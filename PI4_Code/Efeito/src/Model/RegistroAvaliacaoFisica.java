/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author deive
 */
public class RegistroAvaliacaoFisica {
    private Date dataAvaliacao;
    private double peso;
    private int altura;
    private double pressaoArterial;
    private double batimentoRepouso;
    private Enum nivelConicionamento;
    
    //Métodos acessores

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public double getBatimentoRepouso() {
        return batimentoRepouso;
    }

    public void setBatimentoRepouso(double batimentoRepouso) {
        this.batimentoRepouso = batimentoRepouso;
    }

    public Enum getNivelConicionamento() {
        return nivelConicionamento;
    }

    public void setNivelConicionamento(Enum nivelConicionamento) {
        this.nivelConicionamento = nivelConicionamento;
    }
    
    
}
