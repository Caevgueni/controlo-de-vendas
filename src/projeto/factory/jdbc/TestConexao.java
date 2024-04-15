/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.factory.jdbc;

import javax.swing.JOptionPane;


public class TestConexao {
    public static void main(String[] args) {
        try {
             new ConnectionFactory().getConnection();
             JOptionPane.showMessageDialog(null, "conectado com sucesso");
             
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
    
}
