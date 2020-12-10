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
public class RegistroMedidas {
    
    private Date dataMedicao;
    private double pescoco;
    private double peito;
    private double braco;
    private double antebraco;
    private  double cintura;
    private double quadril;
    private double coxa;
    private double panturrilha;
    
    //Métodos acessores

    public Date getDataMedicao() {
        return dataMedicao;
    }

    public void setDataMedicao(Date dataMedicao) {
        this.dataMedicao = dataMedicao;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getPeito() {
        return peito;
    }

    public void setPeito(double peito) {
        this.peito = peito;
    }

    public double getBraco() {
        return braco;
    }

    public void setBraco(double braco) {
        this.braco = braco;
    }

    public double getAntebraco() {
        return antebraco;
    }

    public void setAntebraco(double antebraco) {
        this.antebraco = antebraco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getCoxa() {
        return coxa;
    }

    public void setCoxa(double coxa) {
        this.coxa = coxa;
    }

    public double getPanturrilha() {
        return panturrilha;
    }

    public void setPanturrilha(double panturrilha) {
        this.panturrilha = panturrilha;
    }
    
    
}
