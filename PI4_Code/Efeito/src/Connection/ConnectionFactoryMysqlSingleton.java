/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carolina
 * @author Deive
 */

public class ConnectionFactoryMysqlSingleton implements ConnectionFactoryInterface{
    private final String nomeBanco = "sistema_efeito";//Nome do banco de dados
    private final String nomeUsuario = "root";//Usuário do servidor
    private final String senhaUsuario = "123456";//Senha do servidor
    private final String enderecoServidor = "localhost";
    private static ConnectionFactoryMysqlSingleton conexao;


    private ConnectionFactoryMysqlSingleton(){
    }

    public static ConnectionFactoryMysqlSingleton getConnectionSingleton(){
        if(conexao == null){
            ConnectionFactoryMysqlSingleton.conexao = new ConnectionFactoryMysqlSingleton();
            return conexao;
        }
        return conexao;
    }
            
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
