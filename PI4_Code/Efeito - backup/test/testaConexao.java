
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
        
        PlanoDAO planoTesteDAO = new PlanoDAO();
        Plano planoTeste = new Plano();
        
        planoTeste.setDataInicio(new Date());
        planoTeste.setNumeroAulasPorSemana(3);
        planoTeste.setValor(300.0);
        
        
        planoTesteDAO.inserir(planoTeste);
        
               
        
        ConnectionFactoryMysqlSingleton factoryMysql = ConnectionFactoryMysqlSingleton.getConnectionSingleton();
        try (Connection con = factoryMysql.getConnection()) {
            System.out.println("Conexão aberta!");
            con.close();
        }
        
        
      
        
    }
}
