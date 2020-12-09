
import Connection.ConnectionFactoryMysql;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author carolina
 * @author deive
 */

public class testaConexao {
    public static void main(String[] args) throws SQLException{
        ConnectionFactoryMysql factoryMysql = new ConnectionFactoryMysql();
        try (Connection con = factoryMysql.getConnection()) {
            System.out.println("Conexão aberta!");
            con.close();
        }
    }
}
