/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.AddExercicio;
import Model.RegistroAlunos;
import Model.SexoEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author carolina
 * @author deive
 */
public class AddExercicioDAO {
    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public AddExercicioDAO() {
        this.openCon = conecta.getConnection();
    }

        public boolean inserir(AddExercicio addExerc) {
        
        String sql = "INSERT INTO cadastro_exercicio(nome_exercicio, grupo_muscular, acao_principal, posicao, observacao) "
                + "VALUES(?,?,?,?,?);";

        try {
            try (PreparedStatement stmt = openCon.prepareStatement(sql)) {
                stmt.setString(1, addExerc.getNome_exercicio());
                stmt.setString(2, addExerc.getGrupo_muscular());
                stmt.setString(3, addExerc.getAcao_principal());
                stmt.setString(4, addExerc.getPosicao());
                stmt.setString(5, addExerc.getObservacao());
                
                stmt.execute();
                stmt.close();
            }
            openCon.close();
            return true;            
        }
        catch (SQLException ex) {
            Logger.getLogger(AddExercicioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
}
