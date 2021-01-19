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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carolina
 */
public class PlanoDAO {
    
    private final Connection openCon;
    private final Connection closeCon;
    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public PlanoDAO() {
        this.openCon = conecta.getConnection();
        this.closeCon = conecta.closeConnection();
    }
    
    public boolean inserir(Plano planoDoAluno) throws SQLException{
        String sql = "INSERT INTO plano(valor, data_inicio, data_final, numero_aulas_por_semana) VALUES (?,?,?);";
        
        try{
            try(PreparedStatement stmt = openCon.prepareStatement(sql)){
                                
                stmt.setDouble(1, planoDoAluno.getValor());
                stmt.setDate(2, new Date(planoDoAluno.getDataInicio().getTime()));
                stmt.setDate(3, new Date(planoDoAluno.getDataFinal().getTime()));
                stmt.setInt(3, planoDoAluno.getNumeroAulasPorSemana());     
                
                stmt.execute();
                closeCon.close();
            }
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(PlanoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        
        }
    }
}
