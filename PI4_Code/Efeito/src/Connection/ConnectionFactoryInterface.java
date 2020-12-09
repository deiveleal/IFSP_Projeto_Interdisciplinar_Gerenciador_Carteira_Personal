package Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;

/**
 * @author carolina
 * @author deive
 */
public interface ConnectionFactoryInterface {
    public Connection getConnection();    
}
