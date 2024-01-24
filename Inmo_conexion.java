

package com.mycompany.inmo_conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inmo_conexion {

    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/inmo";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Inmo_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO CREAR_USUARIO(nombres, cedula, correo, contraseña, nombre_usuario) VALUES ('Fabian H', '108437', 'fabianh@inmo.com', 'hace1','Fabi')");
                    rs = statement.executeQuery("SELECT FROM CREAR_USUARIO");
                    rs.next ();
                    do {
                        System.out.println(rs.getInt("cedula")+" : " + rs.getString("nombre_usuario"));
                    }while (rs.next()); 
            
        } catch (SQLException ex) {
            Logger.getLogger(Inmo_conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
