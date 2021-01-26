package Model.ModelEnum;

public enum RhSangueEnum {
    POSITIVO("Positivo"),
    NEGATIVO("Negativo");

    private String TipoSangue;

    RhSangueEnum(String TipoSangue) {
        this.TipoSangue = TipoSangue;
    }

    public String getRhSangue() {
        return TipoSangue;
    }
}
