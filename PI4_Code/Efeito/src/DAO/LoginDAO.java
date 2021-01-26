package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public LoginDAO() {
        this.openCon = conecta.getConnection();
    }

    public Boolean login(String nome_usuario, String senha) throws SQLException {
        boolean encontrado = false;
        String sql = "SELECT * FROM personal WHERE nome_usuario = ? AND senha = ?;";
        PreparedStatement stm = openCon.prepareStatement(sql);
        stm.setString(1, nome_usuario);
        stm.setString(2, senha);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            encontrado = true;
            openCon.close();
            rs.close();
        }
        return encontrado;
    }
}
