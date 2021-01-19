/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.RegistroAlunos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author deive
 */
public class CadastroAlunoDAO implements DAOInterface {
    private final Connection openCon;
    private final Connection closeCon;
    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public CadastroAlunoDAO() {
        this.openCon = conecta.getConnection();
        this.closeCon = conecta.closeConnection();
    }

    @Override
    public void inserir(RegistroAlunos aluno) {
        String sql = "INSERT INTO Funcionario(idFuncionario,nomeFuncionario,cargo,senha) VALUES(?,?,?,?);";
        try {
            try (PreparedStatement stmt = openCon.prepareStatement(sql)) {
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getDataNascimento().toString());
                stmt.setString(3, aluno.getSexo().toString());
                stmt.setString(4, aluno.getCpf());
                
                stmt.execute();
                closeCon;
            }
            //closeCon;
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(CadastroAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void alterar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
