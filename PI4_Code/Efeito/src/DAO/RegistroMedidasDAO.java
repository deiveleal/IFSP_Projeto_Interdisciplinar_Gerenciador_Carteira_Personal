/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.AddExercicio;
import Model.RegistroAvaliacaoFisica;
import Model.RegistroMedidas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deive
 */
public class RegistroMedidasDAO {
    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

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
        }
        catch (SQLException ex) {
            Logger.getLogger(RegistraAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean inserir(RegistroAvaliacaoFisica regAvaFis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean inserir(AddExercicio addExerc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
