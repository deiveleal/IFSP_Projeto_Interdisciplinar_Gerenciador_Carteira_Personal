/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.Plano;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carolina
 */
public class PlanoDAO {
    
    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public PlanoDAO() {
        this.openCon = conecta.getConnection();
    }
    
    public boolean inserir(Plano planoDoAluno) throws SQLException{
        SimpleDateFormat fmtUS = new SimpleDateFormat("yyyy/MM/dd");
        String dataInicioBD = fmtUS.format(planoDoAluno.getDataInicio());
        String dataFinalBD = fmtUS.format(planoDoAluno.getDataFinal());
        
        
        String sql = "INSERT INTO plano(valor, numero_meses, data_inicio, data_final, +"
                + "numero_aulas_por_semana) VALUES (?,?,?,?,?);";
        
        try{
            try(PreparedStatement stmt = openCon.prepareStatement(sql)){
                                
                stmt.setDouble(1, planoDoAluno.getValor());
                stmt.setInt(2, planoDoAluno.getNumeroMeses());
                stmt.setString(3, dataInicioBD);
                stmt.setString(4, dataFinalBD);
                stmt.setInt(5, planoDoAluno.getNumeroAulasPorSemana());     
                
                stmt.execute();
                stmt.close();
                openCon.close();
                return true;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        
        }
    }
}
