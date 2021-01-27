package Model;

import java.util.Date;

public class RegistroMedidas {

    private int id_aluno;
    private Date data_medicao;
    private double peso;
    private double altura;
    private double pescoco;
    private double peito;
    private double braco;
    private double antebraco;
    private double cintura;
    private double quadril;
    private double coxa;
    private double panturrilha;

    public RegistroMedidas() {
    }

    public RegistroMedidas(int id_aluno, Date data_medicao, double peso, double altura, double pescoco,
            double peito, double braco, double antebraco, double cintura, double quadril, double coxa,
            double panturrilha) {

        this.id_aluno = id_aluno;
        this.data_medicao = data_medicao;
        this.peso = peso;
        this.altura = altura;
        this.pescoco = pescoco;
        this.peito = peito;
        this.braco = braco;
        this.antebraco = antebraco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.coxa = coxa;
        this.panturrilha = panturrilha;
    }

    //Métodos acessores
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Date getData_medicao() {
        return data_medicao;
    }

    public void setData_medicao(Date data_medicao) {
        this.data_medicao = data_medicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
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
