/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Carolina
 * @author Deive
 */
public class LoginDAO implements DAOInterface{

    private final Connection openCon;
    private final Connection closeCon;
    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public LoginDAO() {
        this.openCon = conecta.getConnection();
        this.closeCon = conecta.closeConnection();
    }

    //Método que busca o usuário e a senha
    public Boolean login(String nome_usuario, String senha) throws SQLException {
        boolean encontrado = false;
        String sql = "SELECT * FROM personal WHERE nome_usuario = ? AND senha = ?;";
        PreparedStatement stm = openCon.prepareStatement(sql);
        stm.setString(1, nome_usuario);
        stm.setString(2, senha);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            encontrado = true;
            getCloseCon();
            rs.close();
        }
        return encontrado;
    }

    private Connection getCloseCon() {
        return closeCon;
    }

    @Override
    public void inserir(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
