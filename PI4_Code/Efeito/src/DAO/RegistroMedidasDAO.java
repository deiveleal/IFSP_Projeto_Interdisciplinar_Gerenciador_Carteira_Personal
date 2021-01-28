package DAO;

import Connection.ConnectionFactoryInterface;
import Connection.ConnectionFactoryMysqlSingleton;
import Model.RegistroMedidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroMedidasDAO {

    private final Connection openCon;

    ConnectionFactoryInterface conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public RegistroMedidasDAO() {
        this.openCon = conecta.getConnection();
    }

    public boolean inserir(RegistroMedidas regMedid) {
        SimpleDateFormat fmtUS = new SimpleDateFormat("yyyy/MM/dd");
        String dataBanco = fmtUS.format(regMedid.getData_medicao());

        String sql = "INSERT INTO medidas(id_aluno, data_medicao, peso, altura, pescoco, peito, braco,"
                + "antebraco, cintura, quadril, coxa, panturrilha) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            PreparedStatement stmt = openCon.prepareStatement(sql);

            stmt.setString(1, Integer.toString(regMedid.getId_aluno()));
            stmt.setString(2, dataBanco);
            stmt.setString(3, Double.toString(regMedid.getPeso()));
            stmt.setString(4, Double.toString(regMedid.getAltura()));
            stmt.setString(5, Double.toString(regMedid.getPescoco()));
            stmt.setString(6, Double.toString(regMedid.getPeito()));
            stmt.setString(7, Double.toString(regMedid.getBraco()));
            stmt.setString(8, Double.toString(regMedid.getAntebraco()));
            stmt.setString(9, Double.toString(regMedid.getCintura()));
            stmt.setString(10, Double.toString(regMedid.getQuadril()));
            stmt.setString(11, Double.toString(regMedid.getCoxa()));
            stmt.setString(12, Double.toString(regMedid.getPanturrilha()));

            stmt.execute();
            stmt.close();
            openCon.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistraAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Método que retorna uma lista de medições com base no id do aluno
    public List<RegistroMedidas> getListaMedidas(int id_aluno) {
        List<RegistroMedidas> regMed = new ArrayList<>();
        String sql = "SELECT * FROM medidas WHERE id_aluno = ?";
        try {
            PreparedStatement stmt = openCon.prepareStatement(sql);
            stmt.setInt(1, id_aluno);
            ResultSet ResSet = stmt.executeQuery();
            while (ResSet.next()) {
                RegistroMedidas regMedidas = new RegistroMedidas();

                regMedidas.setId_aluno(ResSet.getInt("id_aluno"));
                regMedidas.setData_medicao(ResSet.getDate("data_medicao"));
                regMedidas.setPeso(ResSet.getDouble("peso"));
                regMedidas.setAltura(ResSet.getDouble("altura"));
                regMedidas.setPescoco(ResSet.getDouble("pescoco"));
                regMedidas.setPeito(ResSet.getDouble("peito"));
                regMedidas.setBraco(ResSet.getDouble("braco"));
                regMedidas.setAntebraco(ResSet.getDouble("antebraco"));
                regMedidas.setCintura(ResSet.getDouble("cintura"));
                regMedidas.setQuadril(ResSet.getDouble("quadril"));
                regMedidas.setCoxa(ResSet.getDouble("coxa"));
                regMedidas.setPanturrilha(ResSet.getDouble("panturrilha"));

                regMed.add(regMedidas);
            }
            stmt.close();
            ResSet.close();
            openCon.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }
        return regMed;
    }

}
