/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carolina
 * @author Deive
 *
 */

public class ConnectionFactoryMysql implements ConnectionFactoryInterface{
    private final String nomeBanco = "sistema_efeito";//Nome do banco de dados
    private final String nomeUsuario = "root";//Usuário do servidor
    private final String senhaUsuario = "123456";//Senha do servidor
    private final String enderecoServidor = "localhost";
            
    @Override
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://" + enderecoServidor + "/" + nomeBanco,
                    nomeUsuario,
                    senhaUsuario);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
