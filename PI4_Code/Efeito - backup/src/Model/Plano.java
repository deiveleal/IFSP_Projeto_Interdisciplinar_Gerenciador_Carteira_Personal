/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author deive
 */
public class Plano{
    private Double valor;
    private Integer idAluno; //vinculo de aluno e plano
    private Integer numeroMeses;
    private Date dataInicio;
    private Date dataFinal;
    private Integer numeroAulasPorSemana;
    private Integer numeroAulasPorMes;
    private Integer numeroAulasTotalDoPlano;
    
    //Métodos acessores

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getNumeroMeses() {
        return numeroMeses;
    }

    public void setNumeroMeses(Integer numeroMeses) {
        this.numeroMeses = numeroMeses;
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
    
    public void setDataFinal(Date dataInicio, Integer numeroMeses) {
        Calendar cal = Calendar.getInstance();
        cal.setTime (dataInicio);
        cal.add (Calendar.MONTH, numeroMeses); 
        this.dataFinal  = cal.getTime(); 
        
    }

    public Integer getNumeroAulasPorSemana() {
        return numeroAulasPorSemana;
    }

    public void setNumeroAulasPorSemana(Integer numeroAulasPorSemana) {
        this.numeroAulasPorSemana = numeroAulasPorSemana;
    }

    public Integer getNumeroAulasPorMes() {
        return numeroAulasPorMes;
    }

    public void setNumeroAulasPorMes(Integer numeroAulasPorMes) {
        this.numeroAulasPorMes = numeroAulasPorMes;
    }

    public Integer getNumeroAulasTotalDoPlano() {
        return numeroAulasTotalDoPlano;
    }

    public void setNumeroAulasTotalDoPlano(Integer numeroAulasTotalDoPlano) {
        this.numeroAulasTotalDoPlano = numeroAulasTotalDoPlano;
    }
    
    
}
