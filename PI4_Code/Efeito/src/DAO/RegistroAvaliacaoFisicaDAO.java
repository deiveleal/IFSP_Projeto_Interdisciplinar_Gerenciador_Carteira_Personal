/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.RegistroAvaliacaoFisica;
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
public class RegistroAvaliacaoFisicaDAO {
    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public RegistroAvaliacaoFisicaDAO() {
        this.openCon = conecta.getConnection();
    }          

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
            stmt.setString(5, regAvaFis.getNivel_condicionamento().toString().toLowerCase());
           
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
}
