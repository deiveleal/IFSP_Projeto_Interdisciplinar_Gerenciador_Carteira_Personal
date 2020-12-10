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
public class Plano{
    private double valor;
    private Date dataInicio;
    private Date dataFinal;
    private int numeroAulasPorSemana;
    private int numeroAulasPorMes;
    private int numeroAulasTotalDoPlano;
    
    //Métodos acessores

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getNumeroAulasPorSemana() {
        return numeroAulasPorSemana;
    }

    public void setNumeroAulasPorSemana(int numeroAulasPorSemana) {
        this.numeroAulasPorSemana = numeroAulasPorSemana;
    }

    public int getNumeroAulasPorMes() {
        return numeroAulasPorMes;
    }
    
    public void setNumeroAulasPorMes() {
        //metodo para calcular numero de aulas por mes(em relação ao mes)
        this.numeroAulasPorMes = this.numeroAulasPorSemana * 4;
    }
    
    public void setNumeroAulasPorMes(int numeroAulasPorMes) {
        this.numeroAulasPorMes = numeroAulasPorMes;
    }

    public int getNumeroAulasTotalDoPlano() {
        return numeroAulasTotalDoPlano;
    }

    public void setNumeroAulasTotalDoPlano(int numeroAulasTotalDoPlano) {
        this.numeroAulasTotalDoPlano = numeroAulasTotalDoPlano;
    }
    
    public void setNumeroAulasTotalDoPlano() {
        // alterar valor 3 para funcão que calcula numero de meses do plano
        this.numeroAulasTotalDoPlano = this.numeroAulasPorMes * 3;
    }
    
}
