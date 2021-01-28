package Model;

import java.util.Date;

public class RegistroAlunos extends RegistroPessoa {

    public RegistroAlunos() {
    }

    public RegistroAlunos(String nome, Date dataNascimento, Enum sexo, String cpf, String email, Enum tipoSanguineo,
            Enum rhSangue, String telefone, String celular, String rua, String bairro, String cidade) {
        super.setNome(nome);
        super.setDataNascimento(dataNascimento);
        super.setSexo(sexo);
        super.setCpf(cpf);
        super.setEmail(email);
        super.setTipoSanguineo(tipoSanguineo);
        super.setRhSangue(rhSangue);
        super.setTelefone(telefone);
        super.setCelular(celular);
        super.setRua(rua);
        super.setBairro(bairro);
        super.setCidade(cidade);
    }

    ;

    public RegistroAlunos(int id_aluno, Date data_medicao, double peso, double altura, double pescoco, double peito, double braco, double antebraco, double cintura, double quadril, double coxa, double panturrilha) {
    }

    @Override
    public void criaGrupos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
