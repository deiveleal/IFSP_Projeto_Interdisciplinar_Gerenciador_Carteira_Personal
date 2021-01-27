package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.ModelEnum.CondicionamentoFisicoEnum;
import Model.RegistroAvaliacaoFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroAvaliacaoFisicaDAO{

    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public RegistroAvaliacaoFisicaDAO() {
        this.openCon = conecta.getConnection();
    }

    //Método que insere o registro de uma avaliação física
    public boolean inserir(RegistroAvaliacaoFisica regAvaFis) {
        SimpleDateFormat fmtUS = new SimpleDateFormat("yyyy/MM/dd");
        String dataBanco = fmtUS.format(regAvaFis.getData_avaliacao());

        String sql = "INSERT INTO avaliacao_fisica(id_aluno, data_avaliacao, "
                + "pressao_art, batimento_repouso, nivel_condicionamento) "
                + "VALUES(?,?,?,?,?);";

        try {
            PreparedStatement stmt = openCon.prepareStatement(sql);

            stmt.setString(1, Integer.toString(regAvaFis.getId_aluno()));
            stmt.setString(2, dataBanco);
            stmt.setString(3, Double.toString(regAvaFis.getPressao_art()));
            stmt.setString(4, Double.toString(regAvaFis.getBatimento_repouso()));
            stmt.setString(5, regAvaFis.getNivel_condicionamento().toString());

            stmt.execute();
            stmt.close();
            openCon.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistraAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Método que retorna uma lista de Avaliações com base no id do aluno
    public List<RegistroAvaliacaoFisica> getListAvaliacaoFisica(int id_aluno) {
        List<RegistroAvaliacaoFisica> regAvalFisica = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao_fisica WHERE id_aluno = ?";
        try {
            PreparedStatement stmt = openCon.prepareStatement(sql);
            stmt.setInt(1, id_aluno);
            ResultSet ResSet = stmt.executeQuery();
            while (ResSet.next()) {
                RegistroAvaliacaoFisica regAvaFis = new RegistroAvaliacaoFisica();

                regAvaFis.setId_aluno(ResSet.getInt("id_aluno"));
                regAvaFis.setData_avaliacao(ResSet.getDate("data_avaliacao"));
                regAvaFis.setPressao_art(ResSet.getDouble("pressao_art"));
                regAvaFis.setBatimento_repouso(ResSet.getDouble("batimento_repouso"));
                regAvaFis.setNivel_condicionamento(Enum.valueOf(CondicionamentoFisicoEnum.class, ResSet.getString("nivel_condicionamento")));

                regAvalFisica.add(regAvaFis);
            }
            stmt.close();
            ResSet.close();
            openCon.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }
        return regAvalFisica;
    }

}
