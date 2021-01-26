package Model;

import java.util.Date;

public class RegistroAvaliacaoFisica {

    private int id_aluno;
    private Date data_avaliacao;
    private double pressao_art;
    private double batimento_repouso;
    private Enum nivel_condicionamento;

    public RegistroAvaliacaoFisica(int id_aluno, Date data_avaliacao, double pressao_art, double batimento_repouso, Enum nivel_condicionamento) {
        this.id_aluno = id_aluno;
        this.data_avaliacao = data_avaliacao;
        this.pressao_art = pressao_art;
        this.batimento_repouso = batimento_repouso;
        this.nivel_condicionamento = nivel_condicionamento;
    }

    public RegistroAvaliacaoFisica() {
    }

    //Métodos acessores
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Date getData_avaliacao() {
        return data_avaliacao;
    }

    public void setData_avaliacao(Date data_avaliacao) {
        this.data_avaliacao = data_avaliacao;
    }

    public double getPressao_art() {
        return pressao_art;
    }

    public void setPressao_art(double pressao_art) {
        this.pressao_art = pressao_art;
    }

    public double getBatimento_repouso() {
        return batimento_repouso;
    }

    public void setBatimento_repouso(double batimento_repouso) {
        this.batimento_repouso = batimento_repouso;
    }

    public Enum getNivel_condicionamento() {
        return nivel_condicionamento;
    }

    public void setNivel_condicionamento(Enum nivel_condicionamento) {
        this.nivel_condicionamento = nivel_condicionamento;
    }

}
