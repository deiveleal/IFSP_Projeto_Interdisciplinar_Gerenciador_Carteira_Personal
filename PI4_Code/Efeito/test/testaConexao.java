
import Connection.ConnectionFactoryMysqlSingleton;
import DAO.PlanoDAO;
import Model.Plano;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author carolina
 * @author deive
 */

public class testaConexao {
    public static void main(String[] args) throws SQLException{
        
        ConnectionFactoryMysqlSingleton factoryMysql = ConnectionFactoryMysqlSingleton.getConnectionSingleton();
        try (Connection con = factoryMysql.getConnection()) {
            System.out.println("Conexão aberta!");
            con.close();
        }
        
        
        Plano planoTeste = new Plano();
        PlanoDAO planoTesteDAO = new PlanoDAO();
        
        planoTeste.setDataInicio(new Date());
        System.out.println(planoTeste.getDataInicio());
        //planoTeste.setNumeroAulasPorSemana(3);
    }
}
