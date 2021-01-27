package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.ModelEnum.RhSangueEnum;
import Model.RegistroAlunos;
import Model.ModelEnum.SexoEnum;
import Model.ModelEnum.TipoSanguineoEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistraAlunoDAO {

    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public RegistraAlunoDAO() {
        this.openCon = conecta.getConnection();
    }

    public boolean inserir(RegistroAlunos aluno) {
        SimpleDateFormat fmtUS = new SimpleDateFormat("yyyy/MM/dd");
        String dataBanco = fmtUS.format(aluno.getDataNascimento());

        String sql = "INSERT INTO aluno(nome, data_nascimento, sexo, cpf, email, tipo_sanguineo, rh_sangue,"
                + "telefone, celular, rua, bairro, cidade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            try (PreparedStatement stmt = openCon.prepareStatement(sql)) {
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, dataBanco);
                stmt.setString(3, aluno.getSexo().name());
                stmt.setString(4, aluno.getCpf());
                stmt.setString(5, aluno.getEmail());
                stmt.setString(6, aluno.getTipoSanguineo().name());
                stmt.setString(7, aluno.getRhSangue().name());
                stmt.setString(8, aluno.getTelefone());
                stmt.setString(9, aluno.getCelular());
                stmt.setString(10, aluno.getRua());
                stmt.setString(11, aluno.getBairro());
                stmt.setString(12, aluno.getCidade());

                stmt.execute();
                stmt.close();
            }
            openCon.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistraAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Método que retorna uma lista de alunos
    public List<RegistroAlunos> getList() {
        List<RegistroAlunos> regAlunoList = new ArrayList<>();
        String sql = "SELECT * FROM aluno ORDER BY nome";
        try {
            PreparedStatement stmt = openCon.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while (ResSet.next()) {
                RegistroAlunos regAluno = new RegistroAlunos();

                regAluno.setId_pessoa(ResSet.getInt("id_aluno"));
                regAluno.setNome(ResSet.getString("nome"));
                regAluno.setDataNascimento(ResSet.getDate("data_nascimento"));
                regAluno.setSexo(Enum.valueOf(SexoEnum.class, ResSet.getString("sexo")));
                regAluno.setCpf(ResSet.getString("cpf"));
                regAluno.setEmail(ResSet.getString("email"));
                regAluno.setTipoSanguineo(Enum.valueOf(TipoSanguineoEnum.class, ResSet.getString("tipo_sanguineo")));
                regAluno.setRhSangue(Enum.valueOf(RhSangueEnum.class, ResSet.getString("rh_sangue")));
                regAluno.setTelefone(ResSet.getString("telefone"));
                regAluno.setCelular(ResSet.getString("celular"));
                regAluno.setRua(ResSet.getString("rua"));
                regAluno.setBairro(ResSet.getString("bairro"));
                regAluno.setCidade(ResSet.getString("cidade"));

                regAlunoList.add(regAluno);
            }
            stmt.close();
            ResSet.close();
            openCon.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }
        return regAlunoList;
    }
}
