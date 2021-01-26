package Model.ModelEnum;

public enum SexoEnum {
    MASCULINO("masculino"),
    FEMININO("feminino"),
    NAOBINARIO("não-binario");

    private String TipoSexo;

    SexoEnum(String TipoSexo) {
        this.TipoSexo = TipoSexo;
    }

    public String getSexoEnum() {
        return TipoSexo;
    }
}
