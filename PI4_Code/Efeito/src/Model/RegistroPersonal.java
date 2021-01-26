package Model;

public class RegistroPersonal extends RegistroPessoa {

    public boolean cadastrarAluno() {
        return true;
    }

    public boolean montarTreino() {
        return false;
    }

    public boolean analisarDesempenho() {
        return false;
    }

    public boolean fazerAvaliacao() {
        return false;
    }
}
