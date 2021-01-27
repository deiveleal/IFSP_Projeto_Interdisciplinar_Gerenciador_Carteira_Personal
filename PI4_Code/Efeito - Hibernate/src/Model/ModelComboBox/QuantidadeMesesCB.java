package Model.ModelComboBox;

public class QuantidadeMesesCB {

    private int quantidadeMeses;
    private double valorPlano;
    private String tipoPlano;

    public QuantidadeMesesCB(int quantidadeMeses, double valorPlano, String tipoPlano) {
        this.quantidadeMeses = quantidadeMeses;
        this.valorPlano = valorPlano;
        this.tipoPlano = tipoPlano;
    }

    public QuantidadeMesesCB() {
        this.quantidadeMeses = -1;
        this.valorPlano = -1;
        this.tipoPlano = "vazio -1";
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
