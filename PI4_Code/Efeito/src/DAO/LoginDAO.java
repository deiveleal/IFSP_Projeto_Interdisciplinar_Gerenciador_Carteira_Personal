/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Carolina
 * @author Deive
 */
public class LoginDAO {

    private final Connection con;

    public LoginDAO() {
        this.con = new ConnectionFactoryMysql().getConnection();
    }

    //Método que busca o usuário e a senha
    public Boolean login(String nome_usuario, String senha) throws SQLException {
        boolean encontrado = false;
        String sql = "SELECT * FROM personal WHERE nome_usuario = ? AND senha = ?;";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, nome_usuario);
        stm.setString(2, senha);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            encontrado = true;
            con.close();
            rs.close();
        }
        return encontrado;
    }
}
