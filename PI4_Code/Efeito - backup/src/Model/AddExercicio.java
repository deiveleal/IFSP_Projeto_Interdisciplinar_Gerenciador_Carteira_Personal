/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author carol
 * @author deive
 */
public class AddExercicio{

    private String nome_exercicio;
    private String grupo_muscular;
    private String acao_principal;
    private String posicao;
    private String observacao;
    
    public AddExercicio(String nome_exercicio, String grupo_muscular, String acao_principal, String posicao, String observacao) {
        this.nome_exercicio = nome_exercicio;
        this.grupo_muscular = grupo_muscular;
        this.acao_principal = acao_principal;
        this.posicao = posicao;
        this.observacao = observacao;

    }
    
    public String getNome_exercicio() {
        return nome_exercicio;
    }

    public void setNome_exercicio(String nome_exercicio) {
        this.nome_exercicio = nome_exercicio;
    }

    public String getGrupo_muscular() {
        return grupo_muscular;
    }

    public void setGrupo_muscular(String grupo_muscular) {
        this.grupo_muscular = grupo_muscular;
    }

    public String getAcao_principal() {
        return acao_principal;
    }

    public void setAcao_principal(String acao_principal) {
        this.acao_principal = acao_principal;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
      
}
