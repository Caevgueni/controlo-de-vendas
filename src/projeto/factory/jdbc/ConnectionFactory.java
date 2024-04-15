/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.factory.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {
    
    public Connection getConnection(){ // este connetion é da biblioteca jdbc
        
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas","usuariocurso","123");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
 
        
    }
    
}
