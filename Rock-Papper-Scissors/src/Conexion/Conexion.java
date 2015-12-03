/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucia
 */

public class Conexion {
    private String myDriver;
    private String fqdn;
    private String database;
    private String user;
    private String password;
    
    private static Conexion instancia;
    
    private Conexion(){
      
        this.myDriver = "oracle.jdbc.driver.OracleDriver";
        this.fqdn = "localhost";
        this.database ="XE";//aqui va el nombre de la base de datos
        this.user ="admi";    //su nombre de usuario
        this.password="admi"; //su clave 
        try {
            Class.forName(myDriver);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static Conexion getInstancia(){
        if(instancia==null)
            instancia = new Conexion();
        return instancia;
    }
    
        public Connection getConnection(){
        Connection conn = null;
        try {
             
            String myUrl = "jdbc:oracle:thin:@" + fqdn + ":1521:" + database;
            conn= DriverManager.getConnection(myUrl, user, password);
            System.out.println("conexion exitosa");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return conn;
    }
    
    public Statement getStatement(Connection pConnection){
        Statement st = null;
        try {
            st= pConnection.createStatement();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return st;
    }
    public static void main(String[] args){
   
         
          
          
    }
}
