/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author carolina
 * @author deive
 */
public class ListaExercicios {
    private String nomeExercicio;
    private String acaoPrincipal;
    private String posicao;
    private String observacao;
    
    //Métodos acessores

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public String getAcaoPrincipal() {
        return acaoPrincipal;
    }

    public void setAcaoPrincipal(String acaoPrincipal) {
        this.acaoPrincipal = acaoPrincipal;
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
