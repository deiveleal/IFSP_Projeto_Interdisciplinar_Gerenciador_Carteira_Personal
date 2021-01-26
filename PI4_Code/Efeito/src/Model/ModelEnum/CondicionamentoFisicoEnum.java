package Model.ModelEnum;

public enum CondicionamentoFisicoEnum {
    INICIANTE("iniciante"),
    INTERMEDIARIO("intermediario"),
    AVANÇADO("avançado");

    private String condicionamento;

    CondicionamentoFisicoEnum(String condicionamento) {
        this.condicionamento = condicionamento;
    }

    public String getSexoEnum() {
        return condicionamento;
    }

}
